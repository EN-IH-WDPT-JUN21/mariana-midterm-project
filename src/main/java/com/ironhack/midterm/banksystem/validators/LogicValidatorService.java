package com.ironhack.midterm.banksystem.validators;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dto.operations.TransactionRequestDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.exceptions.EqualAccountsException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogicValidatorService {


    @Autowired
    private AccountRepository accountRepository;


    public Optional<Account>[] validatesTransactionAccounts(TransactionRequestDTO transactionRequestDTO) throws AccountDoesNotExistException, EqualAccountsException {

        Optional<Account> optionalFromAccount = accountRepository.findById(transactionRequestDTO.getFromAccountId());
        Optional<Account> optionalToAccount = accountRepository.findById(transactionRequestDTO.getToAccountId());

        if (optionalFromAccount.get().equals(optionalToAccount.get())){
            throw new EqualAccountsException("The account that initiated the transaction is the same that is receiving the transaction.");
        }else if (optionalFromAccount.isEmpty()) {
            throw new AccountDoesNotExistException("The account that initiated the transaction does not exist.");
        }else if (optionalToAccount.isEmpty()){
            throw new AccountDoesNotExistException("The account that is receiving the transaction does not exist.");
        }

        return new Optional[]{optionalFromAccount, optionalToAccount};

    }


}
