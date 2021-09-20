package com.ironhack.midterm.banksystem.constants;

import java.math.BigDecimal;

public class InterestRate {

    private BigDecimal interestRate;

    public InterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
