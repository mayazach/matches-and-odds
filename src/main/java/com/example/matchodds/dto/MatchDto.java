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
    @Pattern(regexp = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0,1,2])/(19|20)\\d{2}", message = "Date must be in the format dd/MM/yyyy")
    private String matchDate;
    @Pattern(regexp = "^([0-1]?\\d|2[0-3]):[0-5]\\d$", message = "Time must be in the format HH24:MI")
    private String matchTime;
    private String teamA;
    private String teamB;
    @Enumerated(EnumType.STRING)
    private SportsEnum sport;
}