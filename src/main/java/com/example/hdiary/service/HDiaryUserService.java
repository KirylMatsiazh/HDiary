package com.example.hdiary.service;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.repository.HDiaryUserRepository;
import org.springframework.stereotype.Service;

@Service
public class HDiaryUserService {
    private final HDiaryUserRepository hDiaryUserRepository;

    public HDiaryUserService(HDiaryUserRepository hDiaryUserRepository) {
        this.hDiaryUserRepository = hDiaryUserRepository;
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

    public Boolean isEmailTaken(String email){
        return hDiaryUserRepository.existsHDiaryUserByEmail(email);
    }
}
