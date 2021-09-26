package com.ironhack.midterm.banksystem.dto.receipts;

import com.ironhack.midterm.banksystem.enums.Result;
import com.ironhack.midterm.banksystem.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationReceiptDTO {

    @NotNull
    private UserType userType;

    @NotEmpty
    @NotBlank
    private String name;

    private LocalDate dateOfBirth;

    @NotNull
    private Result result;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime date;

}
