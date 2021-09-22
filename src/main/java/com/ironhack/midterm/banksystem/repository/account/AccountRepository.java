package com.ironhack.midterm.banksystem.repository.account;

import com.ironhack.midterm.banksystem.dao.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);
    Account save(Account account);

}
