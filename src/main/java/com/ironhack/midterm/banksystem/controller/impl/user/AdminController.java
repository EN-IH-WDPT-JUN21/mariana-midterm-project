package com.ironhack.midterm.banksystem.controller.impl.user;

import com.ironhack.midterm.banksystem.controller.interfaces.IAdminController;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.receipts.AccountCreationReceiptDTO;
import com.ironhack.midterm.banksystem.dto.receipts.UserCreationReceiptDTO;
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
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController implements IAdminController {

    @Autowired
    private AdminService adminService;


    //Allows the admin to access account details from its id
    @GetMapping("/{id}/account_details")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO accessAccountDetails(@PathVariable(name="id") Long id) throws AccountDoesNotExistException {
        return adminService.accessAccountDetails(id);
    }

    //Allows the admin to update an account's balance
    @PatchMapping("{id}/balance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyBalance(@PathVariable(name="id") Long id, @RequestBody @Valid BigDecimal amountDifference) throws AccountDoesNotExistException {
        adminService.modifyBalance(id, amountDifference);
    }

   //Allows the admin to save a new Account
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountCreationReceiptDTO store(AccountCreationRequestDTO accountCreationRequestDTO) throws UserHasMultipleAccountsException {
        return adminService.storeAccount(accountCreationRequestDTO);
    }

    //Allows the admin to save a new User
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreationReceiptDTO store(UserCreationRequestDTO userCreationRequestDTO) throws UserAlreadyExistsException {
        return adminService.storeUser(userCreationRequestDTO);
    }

    //Allows the Admin to access all the past transactions
    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return adminService.findAll();
    }

}
