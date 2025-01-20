package com.example.matchodds.dto;

import com.example.matchodds.enums.SportsEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class MatchDto {
    @Schema(example = "OSFP-PAO")
    @NotNull(message = "description is required")
    private String description;
    @Schema(example = "31/03/2021")
    @Pattern(regexp = "(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}",
            message = "Date must be in the format dd/MM/yyyy and valid")
    @NotNull(message = "date is required")
    private String matchDate;
    @Schema(example = "12:00")
    @Pattern(regexp = "^([0-1]?\\d|2[0-3]):[0-5]\\d$", message = "Time must be in the format HH24:MI and valid")
    @NotNull(message = "time is required")
    private String matchTime;
    @Schema(example = "OSFP")
    @NotNull(message = "teamA is required")
    private String teamA;
    @Schema(example = "PAO")
    @NotNull(message = "teamB is required")
    private String teamB;
    @Enumerated(EnumType.STRING)
    @Schema(description = "Football (1) or basketball (2)", example = "1")
    @NotNull(message = "sport is required")
    private SportsEnum sport;
}