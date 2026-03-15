package com.example.hdiary.dto.request;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.model.UserStateStats;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateDailyReportRequestDTO {
    // Implement custom state stats validator
    @NotNull
    private UserStateStats stateStats;

    @Size(max = 2000)
    private String note;

    public CreateDailyReportRequestDTO(String note, UserStateStats stateStats){
        this.note = note;
        this.stateStats = stateStats;
    }
}
