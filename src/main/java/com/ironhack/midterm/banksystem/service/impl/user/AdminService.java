package com.ironhack.midterm.banksystem.service.impl.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dto.account.AccountDTO;
import com.ironhack.midterm.banksystem.dto.account.BalanceDTO;
import com.ironhack.midterm.banksystem.exceptions.AccountDoesNotExistException;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.service.interfaces.user.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountDTO accessAccountDetails(Long accountId) throws AccountDoesNotExistException {

        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()){
            AccountDTO account = new AccountDTO();
            account.setId(optionalAccount.get().getId());
            account.setBalance(optionalAccount.get().getBalance());
            account.setUser(optionalAccount.get().getAccountHolder());
            return account;
        }else {
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }

    //Falta verificar se o saldo da conta fica negativo e/ou se é possível ter saldo negativo
    public void modifyBalance(Long accountId, BigDecimal amountDifference) throws AccountDoesNotExistException {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            optionalAccount.get().setBalance( optionalAccount.get().getBalance().add(amountDifference));
            accountRepository.save(optionalAccount.get());
        }else{
            throw new AccountDoesNotExistException("Account does not exist.");
        }

    }


}