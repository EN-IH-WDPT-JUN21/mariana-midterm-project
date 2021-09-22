package com.ironhack.midterm.banksystem.service.interfaces;

import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;

import java.math.BigDecimal;

public interface IAdminService {

    String accessAccountDetails(Long accountId) throws AccountDoesNotExistException;
    BigDecimal accessBalance(Long accountId) throws AccountDoesNotExistException;
}
