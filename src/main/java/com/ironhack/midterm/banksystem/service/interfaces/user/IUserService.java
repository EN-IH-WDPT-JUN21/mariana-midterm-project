package com.ironhack.midterm.banksystem.service.interfaces.user;

import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserDoesNotExistException;

import java.util.List;

public interface IUserService {

    //Receives a transaction request
    //Creates and saves the transaction
    //Returns the transaction receipt
    TransactionReceiptDTO performsTransaction(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException;

    //Receives account id
    //Returns the account's balance
    BalanceDTO accessBalance(Long accountId) throws AccountDoesNotExistException;

    //Receives user id
    //Returns all the transactions of the user
    List<Transaction> getTransactions(Long userId) throws UserAlreadyExistsException, UserDoesNotExistException;

}
