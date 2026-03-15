package com.example.hdiary.dto.request;

import com.example.hdiary.model.Sex;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Data
public class RegisterHDiaryUserRequestDTO {

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

    // Implement custom password validator(password strength approval,
    // common weak passwords rejection)
    @NotNull
    private String password;

    public RegisterHDiaryUserRequestDTO(
            String username,
            LocalDate dateOfBirth,
            Sex sex,
            String email,
            String password
    ){
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.password = password;
    }
}
