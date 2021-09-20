package com.ironhack.midterm.banksystem.controller.impl;

import com.ironhack.midterm.banksystem.controller.interfaces.IAccountController;
import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.repository.account.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
public abstract class AccountController implements IAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/{id}/account_details")
    @ResponseStatus(HttpStatus.OK)
    public String accessAccountDetails(@PathVariable(name="id") Long accountId) {

        Optional<Account> optionalAccount = accountRepository.findByAccountId(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.toString();
        }else {
            return null;
        }
    }

    @GetMapping("{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal accessBalance(@PathVariable(name="id") Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findByAccountId(accountId);

        if (optionalAccount.isPresent()){
            return optionalAccount.get().getBalance().getAmount();
        }else {
            return null;
        }
    }

    


    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account store(@RequestBody @Valid Account account){
        return (Account) accountRepository.save(account);
    }


}
