package com.ironhack.midterm.banksystem.extra;

public class NegativeMoneyAmount extends Exception{

    public NegativeMoneyAmount(String message) {
        super(message);
    }
}
