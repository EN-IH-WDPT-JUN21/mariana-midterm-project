package com.ironhack.midterm.banksystem.service.interfaces.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExists;
import com.ironhack.midterm.banksystem.exceptions.UserHasMultipleAccounts;

import java.math.BigDecimal;

public interface IAdminService {

    AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException;
    void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException;
    public Account storeAccount(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccounts;
    public User storeUser(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExists;
}
