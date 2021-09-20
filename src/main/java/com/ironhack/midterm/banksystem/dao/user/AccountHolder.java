package com.ironhack.midterm.banksystem.dao.user;

import com.ironhack.midterm.banksystem.dao.account.Account;
import com.ironhack.midterm.banksystem.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Table(name = "account_holder")
public class AccountHolder extends User {

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="primary_address")
    private Address primaryAddress;

    @Column(name="mailing_address")
    Optional<Address> mailingAddress;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "account_holder")
    private List<Account> accountList = new ArrayList<>();
}
