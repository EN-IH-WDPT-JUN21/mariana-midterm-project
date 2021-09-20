package com.ironhack.midterm.banksystem.exceptions;

public class NegativeMoneyAmount extends Exception{

    public NegativeMoneyAmount(String message) {
        super(message);
    }
}
