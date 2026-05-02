package com.example.hdiary.dto.response;

import com.example.hdiary.model.UserStateStats;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetDailyReportResponseDTO {
    private UserStateStats stateStats;
    private LocalDate creationDate;
    private String note;

    public GetDailyReportResponseDTO(String note, UserStateStats stateStats, LocalDate creationDate){
        this.creationDate = creationDate;
        this.note = note;
        this.stateStats = stateStats;
    }
}
