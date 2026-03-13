package com.example.hdiary.service;

import com.example.hdiary.model.DailyReport;
import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.UserStateStats;
import com.example.hdiary.repository.DailyReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    -Change for custom exceptions
    -Add authorization
*/

@Service
public class DailyReportService {
    private final DailyReportRepository dailyReportRepository;

    public DailyReportService(DailyReportRepository dailyReportRepository) {
        this.dailyReportRepository = dailyReportRepository;
    }

    // CREATE
    public DailyReport createDailyReport(
            HDiaryUser hDiaryUser,
            String note,
            UserStateStats userStateStats
    ){
        DailyReport newDailyReport = new DailyReport(
                hDiaryUser,
                note,
                userStateStats
        );

        return dailyReportRepository.save(newDailyReport);
    }

    // GET ONE
    public DailyReport getDailyReportById(Long id){
        return dailyReportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
    }

    // GET ALL
    public List<DailyReport> getAllDailyReports(HDiaryUser user){
        return dailyReportRepository.findAllByHDiaryUser(user);
    }

    // UPDATE
    public DailyReport updateDailyReport(
            Long id,
            String updatedNote,
            UserStateStats updatedUserStateStats
    ){
        DailyReport dailyReport = this.getDailyReportById(id);
        dailyReport.setNote(updatedNote);
        dailyReport.setStateStats(updatedUserStateStats);

        return dailyReportRepository.save(dailyReport);
    }

    // DELETE
    public  void deleteDailyReport(Long id){
        dailyReportRepository.deleteDailyReportById(id);
    }
}
