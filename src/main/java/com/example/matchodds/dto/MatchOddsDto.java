package com.example.matchodds.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class MatchOddsDto {
    private String specifier;
    private BigDecimal odd;
}
