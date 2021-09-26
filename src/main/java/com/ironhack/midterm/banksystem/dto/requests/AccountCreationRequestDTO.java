package com.ironhack.midterm.banksystem.dto.requests;

import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import com.ironhack.midterm.banksystem.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreationRequestDTO {

    @NotNull
    private AccountType accountType;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private AccountHolder accountHolder;

}
