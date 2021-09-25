package com.ironhack.midterm.banksystem.dao.account;

import ch.qos.logback.core.status.Status;

import com.ironhack.midterm.banksystem.dao.user.AccountHolder;

import extra.constants.PenaltyFee;
import extra.utils.Money;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("3")
public class SavingsAccount extends Account{


    private int secretKey;

//    @Column(name= "minimum_balance")
//    private MinimumBalance minimumBalance = new MinimumBalance(new Money(new BigDecimal("1000")));
//
//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));

    @CreatedDate
    @Column(name= "creation_date")
    private Date creationDate;

//    @Column(name= "interest_rate")
//    private InterestRate interestRate = new InterestRate(new BigDecimal("0.0025"));

 /*   @Column(name= "status")
    @Enumerated(EnumType.STRING)*/
//    private Status status;


}
