package com.example.hdiary.model;

import com.example.hdiary.model.state_stats.*;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // required for embeddability
@Embeddable
public class UserStateStats {
    private Mood mood;
    private Energy energy;
    private Sleep sleep;
    private Social social;
    private Focus focus;
    private Physical physical;
}
