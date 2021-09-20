package com.ironhack.midterm.banksystem.constants;

import com.ironhack.midterm.banksystem.utils.Money;

public class MinimumBalance {

    private Money minimumBalance;

    public MinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
