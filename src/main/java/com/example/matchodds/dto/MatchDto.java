package com.example.matchodds.dto;

import com.example.matchodds.enums.SportsEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class MatchDto {
    private String description;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Date must be in the format dd/MM/yyyy")
    private String matchDate;
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Time must be in the format HH24:MI")
    private String matchTime;
    private String teamA;
    private String teamB;
    @Enumerated(EnumType.STRING)
    private SportsEnum sport;
}