package com.ironhack.midterm.banksystem.dao.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Setter
@DiscriminatorValue("2")
public class StudentCheckingAccount extends Account {




//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));



   /* @Column(name= "status")
    @Enumerated(EnumType.STRING)*/
 //   private Status status;


}
