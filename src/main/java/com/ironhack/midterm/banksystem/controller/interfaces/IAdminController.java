package com.ironhack.midterm.banksystem.controller.interfaces;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.math.BigDecimal;

public interface IAdminController {

    String accessAccountDetails(Long accountId) throws AccountDoesNotExistException;
    BigDecimal accessBalance(Long accountId) throws AccountDoesNotExistException;
    Account store(Account account);
    User store(User user);
}
