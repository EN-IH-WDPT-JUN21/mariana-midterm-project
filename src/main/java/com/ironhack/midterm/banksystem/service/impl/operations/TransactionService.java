package com.ironhack.midterm.banksystem.service.impl.operations;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dao.operations.TransactionRequest;
import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.operations.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Receipt performsTransaction(TransactionRequest transactionRequest) throws AccountDoesNotExistException, EqualAccountsException {

        //first a validation at dto level when you receive the object
        Optional<Account> optionalFromAccount = accountRepository.findById(transactionRequest.getFromAccountId());
        Optional<Account> optionalToAccount = accountRepository.findById(transactionRequest.getToAccountId());

        if (optionalFromAccount.isEmpty()) {
            throw new AccountDoesNotExistException("The account that initiated the transaction does not exist.");
        }else if (optionalToAccount.isEmpty()){
            throw new AccountDoesNotExistException("The account that is receiving the transaction does not exist.");
        }else if(optionalFromAccount.get().equals(optionalToAccount.get())){
            throw new EqualAccountsException("The account that initiated the transaction is the same that is receiving the transaction.");
        }

//        var tempFromAccount = accountRepository.save(optionalFromAccount.get());
//        var tempToAccount = accountRepository.save(optionalToAccount.get());

        //create the receipt
        var receipt = new Receipt();
        receipt.setDate(LocalDateTime.now());
        receipt.setAmount(transactionRequest.getAmount());
        receipt.setFromAccountId(optionalFromAccount.get().getId());
        receipt.setToAccountId(optionalToAccount.get().getId());

        //validate the request
        if (optionalFromAccount.get().getBalance().compareTo(transactionRequest.getAmount()) < 0){
            receipt.setResult(Result.CANCELLED);
            return receipt;
        }

        //create the transaction
        Transaction tempTransaction = new Transaction();
        tempTransaction.setFromAccountId(transactionRequest.getFromAccountId());
        tempTransaction.setToAccountId(transactionRequest.getToAccountId());
        tempTransaction.setAmount(transactionRequest.getAmount());
        var tempTransaction2 = transactionRepository.save(tempTransaction);

        //Should this be someplace else?
        optionalFromAccount.get().setBalance(optionalFromAccount.get().getBalance().subtract(tempTransaction.getAmount()));
        optionalToAccount.get().setBalance(optionalToAccount.get().getBalance().add(tempTransaction.getAmount()));


        receipt.setTransactionId(tempTransaction2.getId());
        receipt.setResult(Result.OK);

        return receipt;
    }
}
