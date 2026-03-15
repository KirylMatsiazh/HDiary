package com.example.hdiary.dto.response;

import com.example.hdiary.model.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class LoginHDiaryUserResponseDTO {
    // Implement custom username validator(no symbols, length,
    // common weak user-names rejection, already user user-names rejection)
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Past
    private LocalDate dateOfBirth;

    // Implement custom sex validator
    @NotNull
    private Sex sex;

    @NotNull
    @Email
    private String email;

    public LoginHDiaryUserResponseDTO(
            String username,
            LocalDate dateOfBirth,
            Sex sex,
            String email
    ){
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
    }
}
