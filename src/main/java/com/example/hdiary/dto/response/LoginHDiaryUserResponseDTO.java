package com.example.hdiary.dto.response;

import com.example.hdiary.model.Sex;
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
