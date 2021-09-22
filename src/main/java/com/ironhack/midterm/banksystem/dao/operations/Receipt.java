package com.ironhack.midterm.banksystem.dao.operations;

import com.ironhack.midterm.banksystem.dao.account.AccountTwo;
import com.ironhack.midterm.banksystem.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private LocalDateTime date;
    private Long transactionId;
    private Result result;

}
