package com.ironhack.midterm.banksystem.service.interfaces.user;

import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;

public interface IAdminService {

    AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException;
    BalanceDTO accessBalance(Long accountId) throws AccountDoesNotExistException;
}
