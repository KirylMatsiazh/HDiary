package com.example.hdiary.repository;

import com.example.hdiary.model.HDiaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HDiaryUserRepository extends JpaRepository<HDiaryUser, Long> {
    Optional<HDiaryUser> findByEmail(String email);
    Optional<HDiaryUser> findByUsername(String username);
}
