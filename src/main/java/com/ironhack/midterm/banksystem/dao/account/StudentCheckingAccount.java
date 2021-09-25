package com.ironhack.midterm.banksystem.dao.account;

import ch.qos.logback.core.status.Status;
import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@NoArgsConstructor
@Entity
@Setter
@DiscriminatorValue("2")
public class StudentCheckingAccount extends Account {


    private int secretKey;

//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));

    @CreatedDate
    @Column(name= "creation_date")
    private Date creationDate;

   /* @Column(name= "status")
    @Enumerated(EnumType.STRING)*/
 //   private Status status;


}
