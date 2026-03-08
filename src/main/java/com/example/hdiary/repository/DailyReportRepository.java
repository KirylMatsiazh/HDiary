package com.example.hdiary.repository;

import com.example.hdiary.model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
}
