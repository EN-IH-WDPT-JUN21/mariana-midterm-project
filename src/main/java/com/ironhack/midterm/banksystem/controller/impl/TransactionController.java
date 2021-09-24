package com.ironhack.midterm.banksystem.controller.impl;

import com.ironhack.midterm.banksystem.controller.interfaces.ITransactionController;
import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dto.operations.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.service.impl.operations.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class TransactionController implements ITransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.findAll();
    }

    @PostMapping
    public Receipt performsTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {
        return transactionService.performsTransaction(transactionRequestDTO);
    }
}
