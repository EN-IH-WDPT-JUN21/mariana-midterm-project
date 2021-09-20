package com.ironhack.midterm.banksystem.service.impl;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.repository.account.AccountRepository;
import com.ironhack.midterm.banksystem.service.interfaces.IAccountService;
import com.ironhack.midterm.banksystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void updateBalance(Long accountId, Money balanceDifference) {
        Optional<Account> optionalAccount = accountRepository.findByAccountId(accountId);
        if(optionalAccount.isPresent()) {
            if(balanceDifference.getAmount().compareTo(BigDecimal.ZERO) > 0)
            optionalAccount.get().setBalance(new Money(optionalAccount.get().getBalance().increaseAmount(balanceDifference.getAmount())));
        }
        else if(balanceDifference.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            optionalAccount.get().setBalance(new Money(optionalAccount.get().getBalance().decreaseAmount(balanceDifference.getAmount().abs())));
        }

    }
}
