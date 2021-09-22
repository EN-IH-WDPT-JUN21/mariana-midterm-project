package com.ironhack.midterm.banksystem.dao.user;

import com.ironhack.midterm.banksystem.dao.account.AccountTwo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "user_two")
public class UserTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountTwo account;
}
