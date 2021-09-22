package com.ironhack.midterm.banksystem.controller.impl;

import com.ironhack.midterm.banksystem.dao.account.AccountTwo;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountTwoRepository;
import com.ironhack.midterm.banksystem.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountTwoRepository accountTwoRepository;

    @GetMapping("/{id}/account_details")
    @ResponseStatus(HttpStatus.OK)
    public String accessAccountDetails(@PathVariable(name="id") Long accountId) throws AccountDoesNotExistException {
        return adminService.accessAccountDetails(accountId);
    }

    @GetMapping("{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal accessBalance(@PathVariable(name="id") Long accountId) throws AccountDoesNotExistException {
        return adminService.accessBalance(accountId);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountTwo store(@RequestBody @Valid AccountTwo account){
        return accountTwoRepository.save(account);
    }




}
