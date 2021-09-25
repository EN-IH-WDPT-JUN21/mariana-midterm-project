package com.ironhack.midterm.banksystem.controller.interfaces;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;

import java.math.BigDecimal;

public interface IAdminController {

    AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException;
    void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException;
    Account store(Account account);
    User store(User user);
}
