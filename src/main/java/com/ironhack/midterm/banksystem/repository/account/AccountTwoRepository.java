package com.ironhack.midterm.banksystem.repository.account;

import com.ironhack.midterm.banksystem.dao.account.AccountTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTwoRepository extends JpaRepository<AccountTwo, Long> {

    Optional<AccountTwo> findById(Long id);

}
