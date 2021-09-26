package com.ironhack.midterm.banksystem.dao.account;


import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import com.ironhack.midterm.banksystem.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type",
        discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "account")
public abstract class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance = new BigDecimal("0");

    @NotNull
    @OneToOne(mappedBy = "account")
    private AccountHolder accountHolder;

    @CreatedDate
    @Column(name= "creation_date")
    private Date creationDate;


}
