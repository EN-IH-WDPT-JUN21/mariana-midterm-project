package com.ironhack.midterm.banksystem.constants;

import com.ironhack.midterm.banksystem.utils.Money;

public class PenaltyFee {

    private Money penaltyFee;

    public PenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
