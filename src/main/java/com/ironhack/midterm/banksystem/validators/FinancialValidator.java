package com.ironhack.midterm.banksystem.validators;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dto.receipts.TransactionReceiptDTO;
import com.ironhack.midterm.banksystem.dto.requests.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.enums.Result;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FinancialValidator {

    //Receives from account and transaction request
    //Checks if Account has enough funds
    //Returns respective boolean
    public boolean hasEnoughFunds(TransactionRequestDTO transactionRequestDTO, Optional<Account> optionalFromAccount){
        if (optionalFromAccount.get().getBalance().compareTo(transactionRequestDTO.getAmount()) < 0){
            return false;
        }
        return true;
    }
}
