package com.example.hdiary.repository;

import com.example.hdiary.model.DailyReport;
import com.example.hdiary.model.HDiaryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    List<DailyReport> findAllByHDiaryUser(HDiaryUser user);

    void deleteDailyReportById(Long id);
}
