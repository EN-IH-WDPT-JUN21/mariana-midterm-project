package com.ironhack.midterm.banksystem.extra.constants;

import com.ironhack.midterm.banksystem.extra.utils.Money;

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
