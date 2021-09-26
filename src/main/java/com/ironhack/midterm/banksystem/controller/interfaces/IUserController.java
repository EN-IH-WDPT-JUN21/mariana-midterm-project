package com.ironhack.midterm.banksystem.controller.interfaces;

import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserDoesNotExistException;

import java.util.List;

public interface IUserController {

    //Allows the user to check the balance from the account id
    BalanceDTO accessBalance(Long id) throws AccountDoesNotExistException;

    //Allows the user to perform a transaction
    TransactionReceiptDTO performsTransaction(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException;

    //Allows the user to check his/hers past transactions
    List<Transaction> getTransactions(Long id) throws UserAlreadyExistsException, UserDoesNotExistException;
}
