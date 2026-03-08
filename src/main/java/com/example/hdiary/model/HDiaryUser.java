package com.example.hdiary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
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

}
