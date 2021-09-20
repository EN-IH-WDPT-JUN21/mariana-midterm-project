package com.ironhack.midterm.banksystem.repository.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.user.Admin;
import com.ironhack.midterm.banksystem.dao.user.ThirdParty;
import com.ironhack.midterm.banksystem.utils.Money;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends UserRepository<Admin>{

    Account createNewCheckingAccount();
    Account createNewSavingsAccount();
    Account createNewCreditCard();
    Money increaseBalance();
    Money decreaseBalance();
    ThirdParty addThirdPartyUser();
}
