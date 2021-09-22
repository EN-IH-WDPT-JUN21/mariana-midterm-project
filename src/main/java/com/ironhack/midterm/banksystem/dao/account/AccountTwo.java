package com.ironhack.midterm.banksystem.dao.account;

import com.ironhack.midterm.banksystem.dao.user.UserTwo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "account_two")
public class AccountTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @OneToOne(mappedBy = "account")
    private UserTwo user;

}
