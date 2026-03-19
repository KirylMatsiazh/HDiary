package com.example.hdiary.controller;

import com.example.hdiary.dto.request.LoginHDiaryUserRequestDTO;
import com.example.hdiary.dto.request.RegisterHDiaryUserRequestDTO;
import com.example.hdiary.dto.response.LoginHDiaryUserResponseDTO;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.service.HDiaryUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HDiaryUserController {
    private final HDiaryUserService hDiaryUserService;

    public HDiaryUserController(HDiaryUserService hDiaryUserService){
        this.hDiaryUserService = hDiaryUserService;
    }

    @PostMapping("/login")
    public LoginHDiaryUserResponseDTO logInHDiaryUser(
            @RequestBody
            @Valid
            LoginHDiaryUserRequestDTO loginHDiaryUserRequest
    ){
        HDiaryUser loggedInUser = hDiaryUserService.logIn(
                loginHDiaryUserRequest.getEmail(),
                loginHDiaryUserRequest.getPassword()
        );

        return new LoginHDiaryUserResponseDTO(
          loggedInUser.getUsername(),
          loggedInUser.getDateOfBirth(),
          loggedInUser.getSex(),
          loggedInUser.getEmail()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<LoginHDiaryUserResponseDTO> registerHDiaryUser(
            @RequestBody
            @Valid
            RegisterHDiaryUserRequestDTO registerHDiaryUserRequest
    ){
        HDiaryUser registeredUser = hDiaryUserService.register(
                registerHDiaryUserRequest.getUsername(),
                registerHDiaryUserRequest.getDateOfBirth(),
                registerHDiaryUserRequest.getSex(),
                registerHDiaryUserRequest.getEmail(),
                registerHDiaryUserRequest.getPassword()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new LoginHDiaryUserResponseDTO(
                        registeredUser.getUsername(),
                        registeredUser.getDateOfBirth(),
                        registeredUser.getSex(),
                        registeredUser.getEmail()
                )
        );
    }
}
