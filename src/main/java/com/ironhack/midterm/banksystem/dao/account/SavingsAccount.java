package com.ironhack.midterm.banksystem.dao.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@DiscriminatorValue("3")
public class SavingsAccount extends Account{

//    @Column(name= "minimum_balance")
//    private MinimumBalance minimumBalance = new MinimumBalance(new Money(new BigDecimal("1000")));
//
//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));



//    @Column(name= "interest_rate")
//    private InterestRate interestRate = new InterestRate(new BigDecimal("0.0025"));

 /*   @Column(name= "status")
    @Enumerated(EnumType.STRING)*/
//    private Status status;


}
