package com.ironhack.midterm.banksystem.extra.constants;

import com.ironhack.midterm.banksystem.extra.utils.Money;

public class MonthlyMaintenanceFee {

    private Money monthlyMaintenanceFee;

    public MonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}