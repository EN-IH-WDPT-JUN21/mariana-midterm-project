package com.ironhack.midterm.banksystem.dao.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Setter
@DiscriminatorValue("2")
public class StudentCheckingAccount extends Account {

    public StudentCheckingAccount() { super(); }

}
