package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.exceptions.UserDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.operations.TransactionRepository;
import com.ironhack.midterm.banksystem.service.interfaces.user.IUserService;
import com.ironhack.midterm.banksystem.validators.FinancialValidator;
import com.ironhack.midterm.banksystem.validators.LogicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private LogicValidator logicValidator;

    @Autowired
    private FinancialValidator financialValidator;

    @Autowired
    private AccountRepository accountRepository;


    //Receives a transaction request
    //Creates and saves the transaction
    //Returns the transaction receipt
    public TransactionReceiptDTO performsTransaction(@Valid TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {

        //Will store From and To accounts
        Optional<Account>[] optionalAccounts;

        //Validates if the accounts from and to exist and are not the same
        try {
           optionalAccounts = logicValidator.validatesTransactionAccounts(transactionRequestDTO);
        }catch (EqualAccountsException e){
            throw new EqualAccountsException(e.getMessage());
        }catch (AccountDoesNotExistException e){
            throw new AccountDoesNotExistException(e.getMessage());
        }

        //Stores the values in the array into its own object
        Optional<Account> optionalFromAccount = optionalAccounts[0];
        Optional<Account> optionalToAccount = optionalAccounts[1];

        //Creates the receipt
        TransactionReceiptDTO transactionReceiptDTO = createsReceiptWithoutResult(transactionRequestDTO, optionalFromAccount, optionalToAccount);

        //Validates if the From Account has enough funds to perform the Transaction
        if(!financialValidator.hasEnoughFunds(transactionRequestDTO, optionalFromAccount)) {
            transactionReceiptDTO.setResult(Result.CANCELLED);
            return transactionReceiptDTO;
        }

        //Creates and saves the transaction
        Transaction transaction = transfersMoney(transactionRequestDTO, optionalFromAccount, optionalToAccount);

        //Fills Transaction ID and Result in the Receipt
        transactionReceiptDTO.setTransactionId(transaction.getId());
        transactionReceiptDTO.setResult(Result.OK);

        //Returns receipt
        return transactionReceiptDTO;

    }

    //Receives a transaction request, a from and to account
    //Performs the transaction
    //Returns the transaction object
    @Transactional
    public Transaction transfersMoney(TransactionRequestDTO transactionRequestDTO, Optional<Account> optionalFromAccount, Optional<Account> optionalToAccount) {

        //Creates a temporary Transaction
        Transaction tempTransaction = new Transaction();

        //Fills transaction values
        tempTransaction.setFromAccountId(transactionRequestDTO.getFromAccountId());
        tempTransaction.setToAccountId(transactionRequestDTO.getToAccountId());
        tempTransaction.setAmount(transactionRequestDTO.getAmount());

        //Saves the transaction
        var tempTransaction2 = transactionRepository.save(tempTransaction);

        //Performs the transaction
        optionalFromAccount.get().setBalance(optionalFromAccount.get().getBalance().subtract(tempTransaction.getAmount()));
        optionalToAccount.get().setBalance(optionalToAccount.get().getBalance().add(tempTransaction.getAmount()));

        //Returns the transaction
        return tempTransaction;

    }

    //Receives the transaction request, a from and to account
    //Creates the receipt without result
    //Returns the receipt without result
    public TransactionReceiptDTO createsReceiptWithoutResult(TransactionRequestDTO transactionRequestDTO, Optional<Account> optionalFromAccount, Optional<Account> optionalToAccount){

        //Creates the receipt
        var receipt = new TransactionReceiptDTO();

        //Fills the receipt attribute
        receipt.setAmount(transactionRequestDTO.getAmount());
        receipt.setDate(LocalDateTime.now());
        receipt.setFromAccountId(optionalFromAccount.get().getId());
        receipt.setToAccountId(optionalToAccount.get().getId());

        //Returns the receipt
        return receipt;

    }

    //Receives account id
    //Returns the account's balance
    public BalanceDTO accessBalance(Long accountId) throws AccountDoesNotExistException {

        //Looks for the account in the database
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        //if it exists, it returns the balance
        //if it doesn't, it throws an exception
        if (optionalAccount.isPresent()) {
            BalanceDTO balance = new BalanceDTO();
            balance.setAmount(optionalAccount.get().getBalance());
            balance.setCurrency("Dollar");
            return balance;
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }

    //Receives user id
    //Returns all the transactions of the user
    public List<Transaction> getTransactions(Long userId) throws UserDoesNotExistException {

        //Checks if User exists
        if (!logicValidator.userExists(userId)) {
            throw new UserDoesNotExistException("There is no user with the id " + userId);
        }

        //returns transaction list
        return transactionRepository.findTransactionsByFromAccountId(userId);

    }

}
