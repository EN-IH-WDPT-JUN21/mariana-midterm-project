package com.ironhack.midterm.banksystem.dto.receipts;

import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
import com.ironhack.midterm.banksystem.enums.AccountType;
import com.ironhack.midterm.banksystem.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreationReceiptDTO {

    @NotNull
    private AccountType accountType;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private AccountHolder accountHolder;

    @NotNull
    private Result result;

    @NotNull
    private Long accountId;

    @NotNull
    @CreatedDate
    private LocalDateTime date;


}
