package com.ironhack.midterm.banksystem.dao.user;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Entity
@Setter
@DiscriminatorValue("1")
public class Admin extends User{
}
