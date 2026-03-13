package com.example.hdiary.service;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.Sex;
import com.example.hdiary.repository.HDiaryUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HDiaryUserService {
    private final HDiaryUserRepository hDiaryUserRepository;

    public HDiaryUserService(HDiaryUserRepository hDiaryUserRepository) {
        this.hDiaryUserRepository = hDiaryUserRepository;
    }

    /*
    -Validation for each field is required;
    -Password hashing is required;
    -Already used username and email verification is required;
    -Password strength verification is required;
     */
    public HDiaryUser register(
            String username,
            LocalDate dateOfBirth,
            Sex sex,
            String email,
            String password
    ){
        HDiaryUser user = new HDiaryUser(
          username,
          dateOfBirth,
          sex,
          email,
          password
        );
        return hDiaryUserRepository.save(user);
    }

    /*
    -Password comparison will require changes after hashing implementation;
    -Transfer object implementation is required not to send the whole entity with sensitive data;
    -Proper exceptions and their handling is required;
     */
    public HDiaryUser logIn(String email, String password){
        HDiaryUser user = hDiaryUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if(user.getPassword().equals(password)){
            return user;
        } else{
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
}
