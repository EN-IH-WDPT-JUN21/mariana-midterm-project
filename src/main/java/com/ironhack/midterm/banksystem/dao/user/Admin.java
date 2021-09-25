package com.ironhack.midterm.banksystem.dao.user;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Setter
@Table(name="admin")
public class Admin extends User{
}
