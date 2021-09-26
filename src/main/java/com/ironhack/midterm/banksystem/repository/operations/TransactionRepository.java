package com.ironhack.midterm.banksystem.repository.operations;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //Returns a list of all the transactions
    List<Transaction> findAll();

    //Stores Transaction
    Transaction save(Transaction transaction);

    //Returns a list of all the transactions of a specific user
    List<Transaction> findTransactionsByFromAccountId(Long id);

}
