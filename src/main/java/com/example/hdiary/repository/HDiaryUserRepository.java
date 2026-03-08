package com.example.hdiary.repository;

import com.example.hdiary.model.HDiaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HDiaryUserRepository extends JpaRepository<HDiaryUser, Long> {
}
