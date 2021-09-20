package com.ironhack.midterm.banksystem.repository.account;

import com.ironhack.midterm.banksystem.dao.account.Checking;

import javax.transaction.Transactional;

@Transactional
public interface CheckingRepository extends AccountRepository<Checking>{
}
