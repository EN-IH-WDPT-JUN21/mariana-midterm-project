package com.ironhack.midterm.banksystem.repository.account;

import com.ironhack.midterm.banksystem.dao.account.Savings;

import javax.transaction.Transactional;

@Transactional
public interface SavingsRepository extends AccountRepository<Savings>{
}
