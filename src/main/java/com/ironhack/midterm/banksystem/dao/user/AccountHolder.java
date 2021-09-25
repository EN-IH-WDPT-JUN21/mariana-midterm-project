package com.ironhack.midterm.banksystem.dao.user;

import com.ironhack.midterm.banksystem.dao.account.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.Date;

import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Table(name="account_holder")
public class AccountHolder extends User {

    @Column(name="date_of_birth")
    private Date dateOfBirth;

//    @OneToOne
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    private Account account;

    //@OneToMany(mappedBy = "accountList", fetch = FetchType.LAZY)
//    @OneToOne
//    @JoinColumn(name = "account_id")
//    Account account;
//    private List<Account> accountList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
}
