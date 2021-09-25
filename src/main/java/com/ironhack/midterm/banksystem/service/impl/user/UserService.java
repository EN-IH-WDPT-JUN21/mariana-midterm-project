package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.operations.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.operations.TransactionRepository;
import com.ironhack.midterm.banksystem.service.interfaces.user.IUserService;
import com.ironhack.midterm.banksystem.validators.LogicValidatorService;
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
    private TransactionRepository transactionRepository;

    @Autowired
    private LogicValidatorService logicValidatorService;

    @Autowired
    private AccountRepository accountRepository;


    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Receipt performsTransaction( @Valid TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {

        //first a validation at dto level when you receive the object(add annotations)
        //it should be in a validator class - component, autowired (logic, finance)


        Optional<Account>[] optionalAccounts;

        try {
           optionalAccounts = logicValidatorService.validatesTransactionAccounts(transactionRequestDTO);
        }catch (EqualAccountsException e){
            throw new EqualAccountsException(e.getMessage());
        }catch (AccountDoesNotExistException e){
            throw new AccountDoesNotExistException(e.getMessage());
        }

        Optional<Account> optionalFromAccount = optionalAccounts[0];
        Optional<Account> optionalToAccount = optionalAccounts[1];



        //create the receipt
        Receipt receipt = createsReceiptWithoutResult(transactionRequestDTO, optionalFromAccount, optionalToAccount);

        //validate the request
        if (optionalFromAccount.get().getBalance().compareTo(transactionRequestDTO.getAmount()) < 0){
            receipt.setResult(Result.CANCELLED);
            return receipt;
        }

        //create the transaction
        Transaction transaction = transfersMoney(transactionRequestDTO, optionalFromAccount, optionalToAccount);

        receipt.setTransactionId(transaction.getId());
        receipt.setResult(Result.OK);

        return receipt;
    }

    @Transactional
    public Transaction transfersMoney(TransactionRequestDTO transactionRequestDTO, Optional<Account> optionalFromAccount, Optional<Account> optionalToAccount) {
        Transaction tempTransaction = new Transaction();
        tempTransaction.setFromAccountId(transactionRequestDTO.getFromAccountId());
        tempTransaction.setToAccountId(transactionRequestDTO.getToAccountId());
        tempTransaction.setAmount(transactionRequestDTO.getAmount());
        var tempTransaction2 = transactionRepository.save(tempTransaction);

        optionalFromAccount.get().setBalance(optionalFromAccount.get().getBalance().subtract(tempTransaction.getAmount()));
        optionalToAccount.get().setBalance(optionalToAccount.get().getBalance().add(tempTransaction.getAmount()));

        return tempTransaction;
    }

    public Receipt createsReceiptWithoutResult(TransactionRequestDTO transactionRequestDTO, Optional<Account> optionalFromAccount, Optional<Account> optionalToAccount){

        var receipt = new Receipt();
        receipt.setDate(LocalDateTime.now());
        receipt.setAmount(transactionRequestDTO.getAmount());
        receipt.setFromAccountId(optionalFromAccount.get().getId());
        receipt.setToAccountId(optionalToAccount.get().getId());

        return receipt;

    }

    public BalanceDTO accessBalance(Long accountId) throws AccountDoesNotExistException {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            BalanceDTO balance = new BalanceDTO();
            balance.setAmount(optionalAccount.get().getBalance());
            //Will have to be updated when we use money object
            balance.setCurrency("Dollar");
            return balance;
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }
}
