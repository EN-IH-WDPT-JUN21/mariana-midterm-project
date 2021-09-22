package com.ironhack.midterm.banksystem.service.user;

import com.ironhack.midterm.banksystem.dao.account.AccountTwo;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AccountTwoRepository accountTwoRepository;


    public String accessAccountDetails(Long accountId) throws AccountDoesNotExistException {

        Optional<AccountTwo> optionalAccount = accountTwoRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.get().toString();
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }


    public BigDecimal accessBalance( Long accountId) throws AccountDoesNotExistException {
        Optional<AccountTwo> optionalAccount = accountTwoRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.get().getBalance();
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }


}
