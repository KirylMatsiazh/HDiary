package com.example.hdiary.dto.response;

import com.example.hdiary.model.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoginHDiaryUserResponseDTO {
    private String username;
    private LocalDate dateOfBirth;
    private Sex sex;
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
