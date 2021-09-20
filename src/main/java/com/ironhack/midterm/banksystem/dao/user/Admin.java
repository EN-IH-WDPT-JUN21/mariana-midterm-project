package com.ironhack.midterm.banksystem.dao.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@Entity
@Setter
@Table(name = "admin")
public class Admin extends User{
}
