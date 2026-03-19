package com.example.hdiary.model;

import com.example.hdiary.model.state_stats.*;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // required for embeddability
@Embeddable
public class UserStateStats {
    @Enumerated(EnumType.STRING)
    private Mood mood;
    @Enumerated(EnumType.STRING)
    private Energy energy;
    @Enumerated(EnumType.STRING)
    private Sleep sleep;
    @Enumerated(EnumType.STRING)
    private Social social;
    @Enumerated(EnumType.STRING)
    private Focus focus;
    @Enumerated(EnumType.STRING)
    private Physical physical;
}
