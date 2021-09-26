package com.ironhack.midterm.banksystem.controller.interfaces;

import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.receipts.AccountCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.receipts.UserCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserHasMultipleAccountsException;

import java.math.BigDecimal;
import java.util.List;

public interface IAdminController {

    //Allows the admin to access account details from its id
    AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException;

    //Allows the admin to update an account's balance
    void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException;

    //Allows the admin to save a new Account
    AccountCreationReceiptDTO store(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccountsException;

    //Allows the admin to save a new User
    UserCreationReceiptDTO store(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExistsException;

    //Allows the Admin to access all the past transactions
    List<Transaction> getAllTransactions();
}
