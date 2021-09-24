//package com.ironhack.midterm.banksystem.dao.account;
//
//import com.ironhack.midterm.banksystem.constants.MinimumBalance;
//import com.ironhack.midterm.banksystem.constants.MonthlyMaintenanceFee;
//import com.ironhack.midterm.banksystem.constants.PenaltyFee;
//import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
//import extra.Status;
//import com.ironhack.midterm.banksystem.utils.Money;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.Optional;
//
//@NoArgsConstructor
//@Entity
//@Table(name = "checking")
//public class Checking extends Account{
//
//    private int secretKey;
//
////    @Column(name= "minimum_balance")
////    private final MinimumBalance minimumBalance = new MinimumBalance(new Money(new BigDecimal("250")));
////
////    @Column(name= "penalty_fee")
////    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));
////
////    @Column(name= "monthly_maintenance_fee")
////    private final MonthlyMaintenanceFee monthlyMaintenanceFee = new MonthlyMaintenanceFee(new Money(new BigDecimal("12")));
//
////    @Column(name= "creation_date")
////    private Date creationDate;
//
//    @Column(name= "status")
//    @Enumerated(EnumType.STRING)
//    private Status status;
////
//    //Constructor without secondaryOwner
//    public Checking(Money balance, AccountHolder primaryOwner, int secretKey,  Date creationDate, Status status) {
//        super(balance, primaryOwner);
//        setSecretKey(secretKey);
//        //setCreationDate(creationDate);
//        setStatus(status);
//    }
//
////    //Constructor with secondaryOwner
////    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey,  Date creationDate, Status status) {
////        super(balance, primaryOwner, secondaryOwner);
////        setSecretKey(secretKey);
////        setCreationDate(creationDate);
////        setStatus(status);
////    }
//
//    public int getSecretKey() {
//        return secretKey;
//    }
//
//    public void setSecretKey(int secretKey) {
//        this.secretKey = secretKey;
//    }
//
////    public MinimumBalance getMinimumBalance() {
////        return minimumBalance;
////    }
////
////
////    public PenaltyFee getPenaltyFee() {
////        return penaltyFee;
////    }
////
////
////    public MonthlyMaintenanceFee getMonthlyMaintenanceFee() {
////        return monthlyMaintenanceFee;
////    }
////
////
////    public Date getCreationDate() {
////        return creationDate;
////    }
////
////    public void setCreationDate(Date creationDate) {
////        this.creationDate = creationDate;
////    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
////    @Override
////    public String toString() {
////        return super.toString() + "\n" +
////                "Minimum Balance: $ " + minimumBalance + "\n" +
////                "Penalty Fee: $" + penaltyFee + "\n" +
////                "Monthly Maintenance Fee: " + monthlyMaintenanceFee + "\n" +
////                "Creation Date: " + creationDate + "\n" +
////                "Status: " + status + "\n";
////    }
//}
