package com.ironhack.midterm.banksystem.repository.user;

import com.ironhack.midterm.banksystem.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    User findUserByName(String name);
}
