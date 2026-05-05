package com.example.hdiary.controller;

import com.example.hdiary.dto.response.GetDailyReportResponseDTO;
import com.example.hdiary.model.DailyReport;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.service.DailyReportService;
import com.example.hdiary.service.HDiaryUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class DailyReportController {
    private final DailyReportService dailyReportService;
    private final HDiaryUserService userService;

    public DailyReportController(DailyReportService dailyReportService, HDiaryUserService userService) {
        this.dailyReportService = dailyReportService;
        this.userService = userService;
    }
    //TODO: authorisation required
    @GetMapping("/all")
    public List<GetDailyReportResponseDTO> getAllDailyReports(){
        HDiaryUser currentUser = getCurrentUser();
        List<DailyReport> reports = dailyReportService.getAllDailyReports(currentUser);

        List<GetDailyReportResponseDTO> reportsResponse = new ArrayList<>();

        reports.forEach((e) -> {
            reportsResponse.add(
                    new GetDailyReportResponseDTO(
                            e.getNote(),
                            e.getStateStats(),
                            e.getCreationDate()
                    )
            );
        });

        return reportsResponse;
    }

    // TODO: authorisation required
    @GetMapping("/{id}")
    public GetDailyReportResponseDTO getDailyReportById(
            @PathVariable Long id
    ){
        DailyReport report = dailyReportService.getDailyReportById(id);
        return new GetDailyReportResponseDTO(
                report.getNote(),
                report.getStateStats(),
                report.getCreationDate()
        );
    }

    private HDiaryUser getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userService.findByEmail(email);
    }
}
