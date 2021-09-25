package com.ironhack.midterm.banksystem.dao.account;

import com.ironhack.midterm.banksystem.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class CheckingAccount extends Account{


}
