package com.ironhack.midterm.banksystem.repository.operations;

import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
