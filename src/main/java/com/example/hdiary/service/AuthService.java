package com.example.hdiary.service;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.Sex;
import com.example.hdiary.repository.HDiaryUserRepository;
import com.example.hdiary.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthService {
    private final HDiaryUserRepository userRepository;
    private final HDiaryUserService userService;
    private final JwtUtil jwtUtil;
    private PasswordEncoder encoder;

    public AuthService(
            HDiaryUserRepository userRepository,
            HDiaryUserService userService,
            JwtUtil jwtUtil,
            PasswordEncoder encoder
    ){
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }


    /*
    TODO ===> Validation for each field is required;
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
                encoder.encode(password)
        );
        return userRepository.save(user);
    }

    /*
    TODO ===> Transfer object implementation is required not to send the whole entity with sensitive data;
    TODO ===> Proper exceptions and their handling is required;
    */
    public String logIn(String email, String password){
        HDiaryUser user = userService.findByEmail(email);

        if(user == null || !encoder.matches(password, user.getPassword())){
            return null;
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
