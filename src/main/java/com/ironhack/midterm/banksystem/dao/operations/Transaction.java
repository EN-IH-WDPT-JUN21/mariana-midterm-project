package com.ironhack.midterm.banksystem.dao.operations;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name ="from_account_id")
    private Long fromAccountId;

    @NotNull
    @Column(name ="to_account_id")
    private Long toAccountId;

    @NotNull
    @Column(name ="amount")
    private BigDecimal amount;

}
