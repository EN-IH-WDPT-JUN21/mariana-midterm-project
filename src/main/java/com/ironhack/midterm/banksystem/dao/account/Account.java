package com.ironhack.midterm.banksystem.dao.account;

import com.ironhack.midterm.banksystem.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "account_two")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance = new BigDecimal("0");

    @NotNull
    @OneToOne(mappedBy = "account")
    private User user;


}
