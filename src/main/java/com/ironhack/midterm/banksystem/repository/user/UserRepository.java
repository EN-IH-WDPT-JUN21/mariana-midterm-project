package com.ironhack.midterm.banksystem.repository.user;

import com.ironhack.midterm.banksystem.dao.operations.Transaction;
import com.ironhack.midterm.banksystem.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    User findUserByName(String name);
    User findUserById(Long id);
    List<Transaction> findTransactionsByUserId(Long id);
}
