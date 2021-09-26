package com.ironhack.midterm.banksystem.controller.impl.user;

import com.ironhack.midterm.banksystem.controller.interfaces.IUserController;
import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.exceptions.UserAlreadyExistsException;
import com.ironhack.midterm.banksystem.exceptions.UserDoesNotExistException;
import com.ironhack.midterm.banksystem.service.impl.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController implements IUserController {

    @Autowired
    private UserService userService;


    //Allows the user to check the balance from the account id
    @GetMapping("/{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public BalanceDTO accessBalance(@PathVariable(name="id") Long id) throws AccountDoesNotExistException {
        return userService.accessBalance(id);
    }

    //Allows the user to check his/hers past transactions
    @GetMapping("/{id}/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getTransactions(@PathVariable(name="id") Long id) throws UserDoesNotExistException, UserAlreadyExistsException {
        return userService.getTransactions(id);
    }

    //Allows the user to perform a transaction
    @PostMapping("/transaction")
    public TransactionReceiptDTO performsTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {
        return userService.performsTransaction(transactionRequestDTO);
    }
}
