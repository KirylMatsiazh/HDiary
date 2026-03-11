package com.example.hdiary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor // required for jpa
public class HDiaryUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private LocalDate dateOfBirth;
    private Sex sex;
    private String email;
    private String password;

    public HDiaryUser(
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
