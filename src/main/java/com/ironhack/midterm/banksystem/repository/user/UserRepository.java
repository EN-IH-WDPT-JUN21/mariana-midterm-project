package com.ironhack.midterm.banksystem.repository.user;

import com.ironhack.midterm.banksystem.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Stores user
    User save(User user);

    //Finds user by name
    User findUserByName(String name);

    //Finds user by id
    User findUserById(Long id);

}
