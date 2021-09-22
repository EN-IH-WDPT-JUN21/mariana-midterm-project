//package com.ironhack.midterm.banksystem.dao.account;
//
//
//import com.ironhack.midterm.banksystem.constants.CreditLimit;
//import com.ironhack.midterm.banksystem.constants.InterestRate;
//import com.ironhack.midterm.banksystem.constants.PenaltyFee;
//import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
//import com.ironhack.midterm.banksystem.extra.InvalidCreditLimit;
//import com.ironhack.midterm.banksystem.extra.InvalidInterestRate;
//import com.ironhack.midterm.banksystem.extra.NegativeMoneyAmount;
//import com.ironhack.midterm.banksystem.utils.Money;
//import lombok.NoArgsConstructor;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//
//@NoArgsConstructor
//@Entity
//@Table(name = "credit_card")
//public class CreditCard extends Account{
//
//    @Column(name= "credit_limit")
//    private CreditLimit creditLimit = new CreditLimit(new Money(new BigDecimal("100")));
//
//    @Column(name= "interest_rate")
//    private InterestRate interestRate = new InterestRate(new BigDecimal("0.2"));
//
//    @Column(name= "penalty_fee")
//    private final PenaltyFee penaltyFee  = new PenaltyFee(new Money(new BigDecimal("40")));
//
//    // Constructor with custom credit limit and custom interest rate + no secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, CreditLimit creditLimit, InterestRate interestRate) throws InvalidCreditLimit, InvalidInterestRate, NegativeMoneyAmount {
//       super(balance, primaryOwner);
//        setCreditLimit(creditLimit);
//       setInterestRate(interestRate);
//    }
//
//    // Constructor with custom credit limit and custom interest rate + secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, CreditLimit creditLimit, InterestRate interestRate) throws InvalidCreditLimit, InvalidInterestRate, NegativeMoneyAmount {
//        super(balance, primaryOwner, secondaryOwner);
//        setCreditLimit(creditLimit);
//        setInterestRate(interestRate);
//    }
//
//
//    // Constructor with custom interest rate + no secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, InterestRate interestRate) throws InvalidInterestRate, NegativeMoneyAmount {
//        super(balance, primaryOwner);
//        setInterestRate(interestRate);
//    }
//
//    // Constructor with custom interest rate + secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, InterestRate interestRate) throws InvalidInterestRate, NegativeMoneyAmount {
//        super(balance, primaryOwner, secondaryOwner);
//        setInterestRate(interestRate);
//    }
//
//
//    // Constructor with custom credit limit + no secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, CreditLimit creditLimit) throws InvalidCreditLimit, NegativeMoneyAmount {
//        super(balance, primaryOwner);
//        setCreditLimit(creditLimit);
//    }
//
//    // Constructor with custom credit limit + secondaryOwner
//    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, CreditLimit creditLimit) throws InvalidCreditLimit, NegativeMoneyAmount {
//        super(balance, primaryOwner, secondaryOwner);
//        setCreditLimit(creditLimit);
//    }
//
//
//
//    public CreditLimit getCreditLimit() {
//        return creditLimit;
//    }
//
//    public void setCreditLimit(CreditLimit creditLimit) throws InvalidCreditLimit {
//        if(creditLimit.getCreditLimit().getAmount().compareTo(new BigDecimal("100")) < 0 ||
//                creditLimit.getCreditLimit().getAmount().compareTo(new BigDecimal("100000")) > 0)
//            throw new InvalidCreditLimit("The credit limit should be between 100 and 100000.");
//
//        this.creditLimit = creditLimit;
//    }
//
//    public InterestRate getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(InterestRate interestRate) throws InvalidInterestRate {
//
//        if(interestRate.getInterestRate().compareTo(new BigDecimal("0.1")) < 0 ||
//                interestRate.getInterestRate().compareTo(new BigDecimal("0.2")) > 0)
//            throw new InvalidInterestRate("The interest rate should be between 0.1 and 0.2.");
//
//
//        this.interestRate = interestRate;
//    }
//
//    public PenaltyFee getPenaltyFee() {
//        return penaltyFee;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\n" +
//                "Credit Limit: $" + creditLimit + "\n" +
//                "Interest Rate: " + interestRate + "%\n" +
//                "Penalty Fee: €" + penaltyFee + "\n";
//    }
//
//}
