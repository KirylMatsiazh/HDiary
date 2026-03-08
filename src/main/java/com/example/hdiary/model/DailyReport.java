package com.example.hdiary.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor // required by jpa
public class DailyReport {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private UserStateStats stateStats;

    @ManyToOne
    @JoinColumn(name = "hdiary_user_id")
    private HDiaryUser hDiaryUser;

    private LocalDate creationDate;
    private String note;


    public DailyReport(HDiaryUser hDiaryUser, String note, UserStateStats stateStats){
        this.hDiaryUser = hDiaryUser;
        this.creationDate = LocalDate.now();
        this.note = note;
        this.stateStats = stateStats;
    }
}
