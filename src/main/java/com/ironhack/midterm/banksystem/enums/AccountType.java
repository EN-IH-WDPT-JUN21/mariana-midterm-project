package com.ironhack.midterm.banksystem.enums;

public enum AccountType {
    SAVINGS, CHECKING, STUDENT_CHECKING;


    private String value;

    public static class Values {
        public static final String SAVINGS = "Savings";
        public static final String CHECKING = "Checking";
        public static final String STUDENT_CHECKING = "Students Checking";
    }
    }
