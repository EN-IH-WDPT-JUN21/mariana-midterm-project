package com.ironhack.midterm.banksystem.repository.user;

import com.ironhack.midterm.banksystem.dao.operations.Receipt;
import com.ironhack.midterm.banksystem.dao.user.AccountHolder;

import javax.transaction.Transactional;

@Transactional
public interface AccountHolderRepository extends UserRepository<AccountHolder>{

    String accessAccountDetails(Long accountId);
    Receipt transferMoney(AccountHolder primaryOwner, AccountHolder secondaryOwner, Long accountId);

}
