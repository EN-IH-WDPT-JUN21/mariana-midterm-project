package com.ironhack.midterm.banksystem.service.interfaces.user;

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

public interface IAdminService {

    //Returns a list of all the Transactions
    List<Transaction> findAll();

    //Receives an account id
    // Returns an account
    AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException;

    //Receives an account id and the amount to add to the account balance
    //Updates the account balance
    void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException;

    //Receives an account creation request
    //Creates and saves the account
    //Returns the account creation receipt
    AccountCreationReceiptDTO storeAccount(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccountsException;

    //Receives an user creation request
    //Creates and saves the user
    //Returns the user creation receipt
    UserCreationReceiptDTO storeUser(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExistsException;
}
