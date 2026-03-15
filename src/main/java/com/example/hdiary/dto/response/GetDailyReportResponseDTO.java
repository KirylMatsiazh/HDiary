package com.example.hdiary.dto.response;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.UserStateStats;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
