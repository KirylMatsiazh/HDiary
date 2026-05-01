package com.example.hdiary.service;

import com.example.hdiary.dto.request.RegisterHDiaryUserRequestDTO;
import com.example.hdiary.dto.response.LoginHDiaryUserResponseDTO;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.Sex;
import com.example.hdiary.repository.HDiaryUserRepository;
import com.example.hdiary.security.JwtUtil;
import jakarta.servlet.http.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Service
public class HDiaryUserService {
    private final HDiaryUserRepository hDiaryUserRepository;
    private final JwtUtil jwtUtil;

    public HDiaryUserService(HDiaryUserRepository hDiaryUserRepository, JwtUtil jwtUtil) {
        this.hDiaryUserRepository = hDiaryUserRepository;
        this.jwtUtil = jwtUtil;
    }

    //SEPARATE AUTH LOGIC IN AUTH SERVICE


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
    public String logIn(String email, String password){
        HDiaryUser user = findByEmail(email);

        if(user == null || !Objects.equals(password, user.getPassword())){
            return null;
        }

        return jwtUtil.generateToken(user.getEmail());
    }

    public HDiaryUser findByEmail(String email){
        return hDiaryUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public HDiaryUser findByUsername(String username){
        return hDiaryUserRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Boolean isUsernameTaken(String username){
        return hDiaryUserRepository.existsHDiaryUserByUsername(username);
    }
}
