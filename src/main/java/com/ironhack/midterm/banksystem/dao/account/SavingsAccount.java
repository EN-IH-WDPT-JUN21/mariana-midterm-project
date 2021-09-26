package com.ironhack.midterm.banksystem.dao.account;


import javax.persistence.*;


@Entity
@DiscriminatorValue("3")
public class SavingsAccount extends Account{

    public SavingsAccount() { super(); }

}
