package com.ironhack.midterm.banksystem.controller.impl.user;

import com.ironhack.midterm.banksystem.controller.interfaces.IAdminController;
import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.User;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.requests.AccountCreationRequestDTO;
import com.ironhack.midterm.banksystem.dto.requests.UserCreationRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserHasMultipleAccountsException;
import com.ironhack.midterm.banksystem.service.impl.user.AdminService;
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


    //user endpoints
    // create operations
    // check his balance
    // check past transactions
    // always check if it is the same user that log on

    //add status and update balance
    //create transaction(just the path) - not the fraud validation -, create users, create accounts
    //read data from account, users and transactions
    //update users (phone number, address, etc), accounts (status, balance)


    @GetMapping("/{id}/account_details")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO accessAccountDetails(@PathVariable(name="id") Long id) throws AccountDoesNotExistException {
        return adminService.accessAccountDetails(id);
    }

    //BalanceDTO - can return an object inside BigDecimal + currency
    @PatchMapping("{id}/balance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyBalance(@PathVariable(name="id") Long id, @RequestBody @Valid BigDecimal amountDifference) throws AccountDoesNotExistException {
        adminService.modifyBalance(id, amountDifference);
    }


    //with various users/accounts, we create the same way we created transaction (usercreationrequest), userdto instead
    //of receipt that has all the data
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account store(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccountsException {
        return adminService.storeAccount(accountCreationRequestDTO);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User store(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExistsException {
        return adminService.storeUser(userCreationRequestDTO);
    }




}
