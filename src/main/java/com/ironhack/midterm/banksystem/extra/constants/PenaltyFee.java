package com.ironhack.midterm.banksystem.extra.constants;

import com.ironhack.midterm.banksystem.extra.utils.Money;

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
