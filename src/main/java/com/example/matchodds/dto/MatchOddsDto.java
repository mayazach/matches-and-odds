package com.example.matchodds.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class MatchOddsDto {
    @Schema(example = "X")
    @NotNull(message = "specifier is required")
    private String specifier;
    @NotNull(message = "odd value is required")
    @Schema(example = "1")
    private BigDecimal odd;
}
