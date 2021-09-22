package com.ironhack.midterm.banksystem.extra.constants;

import com.ironhack.midterm.banksystem.extra.utils.Money;



public class CreditLimit {

    private Money creditLimit;

    public CreditLimit(Money creditLimit) {
        setCreditLimit(creditLimit);
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }
}
