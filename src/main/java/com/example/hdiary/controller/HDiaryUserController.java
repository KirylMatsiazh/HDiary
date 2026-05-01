package com.example.hdiary.controller;

import com.example.hdiary.service.HDiaryUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HDiaryUserController {
    private final HDiaryUserService hDiaryUserService;

    public HDiaryUserController(HDiaryUserService hDiaryUserService){
        this.hDiaryUserService = hDiaryUserService;
    }

}
