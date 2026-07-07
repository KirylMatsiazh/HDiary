package com.example.hdiary.controller;

import com.example.hdiary.dto.request.LoginHDiaryUserRequestDTO;
import com.example.hdiary.dto.request.RegisterHDiaryUserRequestDTO;
import com.example.hdiary.service.AuthService;
import com.example.hdiary.service.HDiaryUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    HDiaryUserService userService;
    @Autowired
    AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginHDiaryUserRequestDTO loginUser) {
        String jwtToken = authService.logIn(loginUser.getEmail(), loginUser.getPassword());

        if(jwtToken == null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid credentials"));
        } else{
            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "email", loginUser.getEmail(),
                    "jwt", jwtToken     // TODO ===> Unsafe: change to returning token in cookies
            ));
        }
    }

    // TODO ===> Implement automatic login after signing up
    @PostMapping("/signup")
    public String registerUser(@Valid @RequestBody RegisterHDiaryUserRequestDTO registerUser) {
        if (userService.isUsernameTaken(registerUser.getUsername())) {
            return "Error: Username is already taken!";     // TODO ===> Set a proper response for this case.
        }

        authService.register(
                registerUser.getUsername(),
                registerUser.getDateOfBirth(),
                registerUser.getSex(),
                registerUser.getEmail(),
                registerUser.getPassword()
        );
        return "User registered successfully!";
    }
}