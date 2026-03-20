package com.example.hdiary.controller;

import com.example.hdiary.dto.request.CreateDailyReportRequestDTO;
import com.example.hdiary.dto.response.GetDailyReportResponseDTO;
import com.example.hdiary.service.DailyReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class DailyReportController {
    private final DailyReportService dailyReportService;

    public DailyReportController(DailyReportService dailyReportService) {
        this.dailyReportService = dailyReportService;
    }


}
