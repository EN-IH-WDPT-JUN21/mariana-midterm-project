package com.ironhack.midterm.banksystem.dao.user;

import com.ironhack.midterm.banksystem.dao.account.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@DiscriminatorValue("2")
public class AccountHolder extends User {

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

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
