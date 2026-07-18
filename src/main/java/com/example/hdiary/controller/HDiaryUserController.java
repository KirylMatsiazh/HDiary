package com.example.hdiary.controller;

import com.example.hdiary.dto.response.LoginHDiaryUserResponseDTO;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.service.HDiaryUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HDiaryUserController {
    private final HDiaryUserService hDiaryUserService;

    public HDiaryUserController(HDiaryUserService hDiaryUserService){
        this.hDiaryUserService = hDiaryUserService;
    }

    @GetMapping("/me")
    public LoginHDiaryUserResponseDTO getMe(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        HDiaryUser user = hDiaryUserService.findByEmail(email);

        return new LoginHDiaryUserResponseDTO(
                user.getUsername(),
                user.getDateOfBirth(),
                user.getSex(),
                user.getEmail()
        );
    }
}
