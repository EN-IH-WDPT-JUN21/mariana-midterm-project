package com.ironhack.midterm.banksystem.dao.account;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class CheckingAccount extends Account{

    public CheckingAccount() { super(); }
}
