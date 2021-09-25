package com.ironhack.midterm.banksystem.dto.receipts;

import com.ironhack.midterm.banksystem.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionReceiptDTO {

    @NotNull
    private Long fromAccountId;
    @NotNull
    private Long toAccountId;
    @NotNull
    private BigDecimal amount;
    @NotNull
    @CreatedDate
    private LocalDateTime date;
    @NotNull
    private Long transactionId;
    @NotNull
    private Result result;

}
