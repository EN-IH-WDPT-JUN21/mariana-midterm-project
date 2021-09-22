package com.ironhack.midterm.banksystem.dao.operations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TransactionRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;

}
