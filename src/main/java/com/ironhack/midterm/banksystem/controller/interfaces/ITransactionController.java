package com.ironhack.midterm.banksystem.controller.interfaces;

import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dao.operations.TransactionRequest;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITransactionController {

    List<Transaction> getTransactions();
    Receipt performsTransaction(TransactionRequest transactionRequest) throws AccountDoesNotExistException, EqualAccountsException;
}
