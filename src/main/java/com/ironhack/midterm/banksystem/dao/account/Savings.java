package com.ironhack.midterm.banksystem.dao.account;

import ch.qos.logback.core.status.Status;
import com.ironhack.midterm.banksystem.constants.InterestRate;
import com.ironhack.midterm.banksystem.constants.MinimumBalance;
import com.ironhack.midterm.banksystem.constants.PenaltyFee;
import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import com.ironhack.midterm.banksystem.exceptions.InterestRateTooHigh;
import com.ironhack.midterm.banksystem.exceptions.InvalidMinimumBalance;
import com.ironhack.midterm.banksystem.utils.Money;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@Entity
@Table(name = "savings")
public class Savings extends Account{


    private int secretKey;

    @Column(name= "minimum_balance")
    private MinimumBalance minimumBalance = new MinimumBalance(new Money(new BigDecimal("1000")));

    @Column(name= "penalty_fee")
    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));

    @Column(name= "creation_date")
    private Date creationDate;

    @Column(name= "interest_rate")
    private InterestRate interestRate = new InterestRate(new BigDecimal("0.0025"));

 /*   @Column(name= "status")
    @Enumerated(EnumType.STRING)*/
    private Status status;

    //All args constructor
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey, MinimumBalance minimumBalance, Date creationDate, InterestRate interestRate, Status status) throws InterestRateTooHigh, InvalidMinimumBalance {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
        setMinimumBalance(minimumBalance);
        setCreationDate(creationDate);
        setInterestRate(interestRate);
        setStatus(status);
    }

    //Constructor with default interest rate but custom minimum balance + no secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner, int secretKey, MinimumBalance minimumBalance, Date creationDate,  Status status) throws InvalidMinimumBalance {
        super(balance, primaryOwner);
        setSecretKey(secretKey);
        setMinimumBalance(minimumBalance);
        setCreationDate(creationDate);
        setStatus(status);
    }

    //Constructor with default interest rate but custom minimum balance + secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner,AccountHolder secondaryOwner, int secretKey, MinimumBalance minimumBalance, Date creationDate,  Status status) throws InvalidMinimumBalance {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
        setMinimumBalance(minimumBalance);
        setCreationDate(creationDate);
        setStatus(status);
    }

    //Constructor with custom interest rate but default minimum balance + no secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner, int secretKey, Date creationDate, InterestRate interestRate, Status status) throws InterestRateTooHigh {
        super(balance, primaryOwner);
        setSecretKey(secretKey);
        setCreationDate(creationDate);
        setInterestRate(interestRate);
        setStatus(status);
    }

    //Constructor with custom interest rate but default minimum balance + secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey, Date creationDate, InterestRate interestRate, Status status) throws InterestRateTooHigh {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
        setCreationDate(creationDate);
        setInterestRate(interestRate);
        setStatus(status);
    }

    //Constructor with default interest rate and default minimum balance + no secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner, int secretKey,  Date creationDate, Status status) throws InterestRateTooHigh {
       super(balance, primaryOwner);
        setSecretKey(secretKey);
        setCreationDate(creationDate);
        setStatus(status);
    }

    //Constructor with default interest rate and default minimum balance +  secondaryOwner
    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, int secretKey,  Date creationDate, Status status) throws InterestRateTooHigh {
        super(balance, primaryOwner, secondaryOwner);
        setSecretKey(secretKey);
        setCreationDate(creationDate);
        setStatus(status);
    }

    public int getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(int secretKey) {
        this.secretKey = secretKey;
    }

    public MinimumBalance getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(MinimumBalance minimumBalance) throws InvalidMinimumBalance {

        if(minimumBalance.getMinimumBalance().getAmount().compareTo(new BigDecimal("100")) < 0 ||
                minimumBalance.getMinimumBalance().getAmount().compareTo(new BigDecimal("1000")) > 0)
            throw new InvalidMinimumBalance("The minimum balance should be between 100 and 1000.");

        this.minimumBalance = minimumBalance;
    }

    public PenaltyFee getPenaltyFee() {
        return penaltyFee;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(InterestRate interestRate) throws InterestRateTooHigh {

        if(interestRate.getInterestRate().compareTo(new BigDecimal("0.5")) > 0)
            throw new InterestRateTooHigh("The maximum interest rate is 0.5");

        this.interestRate = interestRate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Minimum Balance: $ " + minimumBalance + "\n" +
                "Penalty Fee: $" + penaltyFee + "\n" +
                "Interest Rate: " + interestRate + "%\n" +
                "Creation Date: " + creationDate + "\n" +
                "Status: " + status + "\n";
    }
}
