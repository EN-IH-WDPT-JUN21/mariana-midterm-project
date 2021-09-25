package com.ironhack.midterm.banksystem.service.interfaces.user;

import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserDoesNotExistException;

import java.util.List;

public interface IUserService {

    List<Transaction> findAll();
    TransactionReceiptDTO performsTransaction(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException;
    List<Transaction> getTransactions(Long userId) throws UserAlreadyExistsException, UserDoesNotExistException;
}
