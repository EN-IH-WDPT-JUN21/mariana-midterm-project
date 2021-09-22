package com.ironhack.midterm.banksystem.controller.impl;

import com.ironhack.midterm.banksystem.controller.interfaces.IAdminController;
import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.repository.user.UserRepository;
import com.ironhack.midterm.banksystem.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/admin")
public class AdminController implements IAdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

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
    public Account store(@RequestBody @Valid Account account){
        return accountRepository.save(account);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User store(@RequestBody @Valid User user){
        return userRepository.save(user);
    }




}
