package com.example.hdiary.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginHDiaryUserRequestDTO {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public LoginHDiaryUserRequestDTO(
            String email,
            String password
    ){
        this.email = email;
        this.password = password;
    }
}
