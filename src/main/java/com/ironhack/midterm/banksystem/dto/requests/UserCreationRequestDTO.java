package com.ironhack.midterm.banksystem.dto.requests;

import com.ironhack.midterm.banksystem.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequestDTO {

    @NotNull
    private UserType userType;

    @NotEmpty
    @NotBlank
    private String name;

    private LocalDate dateOfBirth;

}
