package com.ironhack.midterm.banksystem.service.interfaces.user;

import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.operations.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;

import java.util.List;

public interface IUserService {

    List<Transaction> findAll();
    Receipt performsTransaction(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException;

}