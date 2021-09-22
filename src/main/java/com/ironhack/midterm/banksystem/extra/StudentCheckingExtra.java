//package com.ironhack.midterm.banksystem.dao.account;
//
//import ch.qos.logback.core.status.Status;
//import com.ironhack.midterm.banksystem.constants.PenaltyFee;
//import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
//import com.ironhack.midterm.banksystem.utils.Money;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//
//
//@Getter
//@NoArgsConstructor
//@Entity
//@Setter
//@Table(name = "student_checking")
//public class StudentChecking extends Account {
//
//
//    private int secretKey;
//
//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));
//
//    @Column(name= "creation_date")
//    private Date creationDate;
//
//   /* @Column(name= "status")
//    @Enumerated(EnumType.STRING)*/
//    private Status status;
//
//    //No secondaryOwner
//    public StudentChecking(Money balance, AccountHolder primaryOwner, int secretKey, Date creationDate, Status status){
//        super(balance, primaryOwner);
//        setSecretKey(secretKey);
//        setCreationDate(creationDate);
//        setStatus(status);
//    }
//
//    //With secondaryOwner
//    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey, Date creationDate, Status status){
//        super(balance, primaryOwner, secondaryOwner);
//        setSecretKey(secretKey);
//        setCreationDate(creationDate);
//        setStatus(status);
//    }
//
//    public int getSecretKey() {
//        return secretKey;
//    }
//
//    public void setSecretKey(int secretKey) {
//        this.secretKey = secretKey;
//    }
//
//    public PenaltyFee getPenaltyFee() {
//        return penaltyFee;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\n" +
//                "Penalty Fee: $" + penaltyFee + "\n" +
//                "Creation Date: " + creationDate + "\n" +
//                "Status: " + status + "\n";
//    }
//}
