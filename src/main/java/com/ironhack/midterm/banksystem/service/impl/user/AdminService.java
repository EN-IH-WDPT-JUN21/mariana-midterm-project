package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.service.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AccountRepository accountRepository;


    public String accessAccountDetails(Long accountId) throws AccountDoesNotExistException {

        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.get().toString();
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }


    public BigDecimal accessBalance( Long accountId) throws AccountDoesNotExistException {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.get().getBalance();
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }


}
