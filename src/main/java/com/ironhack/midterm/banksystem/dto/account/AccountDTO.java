package com.ironhack.midterm.banksystem.dto.account;

import com.ironhack.midterm.banksystem.dao.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    @NotNull
    private Long id;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private User user;

}
