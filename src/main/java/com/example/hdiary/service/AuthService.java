package com.example.hdiary.service;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.Sex;
import com.example.hdiary.repository.HDiaryUserRepository;
import com.example.hdiary.security.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class AuthService {
    private final HDiaryUserRepository userRepository;
    private final HDiaryUserService userService;
    private final JwtUtil jwtUtil;

    public AuthService(HDiaryUserRepository userRepository, HDiaryUserService userService, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    /*
    TODO ===> Validation for each field is required;
    TODO ===> Password hashing is required;
    TODO ===> Already used username and email verification is required;
    TODO ===> Password strength verification is required;
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
        return userRepository.save(user);
    }

    /*
    TODO ===> Password comparison will require changes after hashing implementation;
    TODO ===> Transfer object implementation is required not to send the whole entity with sensitive data;
    TODO ===> Proper exceptions and their handling is required;
    */
    public String logIn(String email, String password){
        HDiaryUser user = userService.findByEmail(email);

        if(user == null || !Objects.equals(password, user.getPassword())){
            return null;
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
