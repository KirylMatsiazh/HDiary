package com.example.hdiary.controller;

import com.example.hdiary.dto.request.LoginHDiaryUserRequestDTO;
import com.example.hdiary.dto.request.RegisterHDiaryUserRequestDTO;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.security.JwtUtil;
import com.example.hdiary.service.HDiaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    HDiaryUserService userService;
    @Autowired
    JwtUtil jwtUtils;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginHDiaryUserRequestDTO loginUser) {
        String jwtToken = userService.logIn(loginUser.getEmail(), loginUser.getPassword());

        if(jwtToken == null){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid credentials"));
        } else{
            return ResponseEntity.ok(Map.of(
                    "message", "Login successful",
                    "email", loginUser.getEmail(),
                    "jwt", jwtToken     // Unsafe: change to returning token in cookies
            ));
        }
    }

    // Implement automatic login after signing up
    @PostMapping("/signup")
    public String registerUser(@RequestBody RegisterHDiaryUserRequestDTO registerUser) {
        if (userService.isUsernameTaken(registerUser.getUsername())) {
            return "Error: Username is already taken!";
        }

        userService.register(
                registerUser.getUsername(),
                registerUser.getDateOfBirth(),
                registerUser.getSex(),
                registerUser.getEmail(),
                registerUser.getPassword()
        );
        return "User registered successfully!";
    }
}