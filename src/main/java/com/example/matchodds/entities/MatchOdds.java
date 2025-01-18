package com.example.matchodds.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Entity(name = "match_odds")
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchOdds extends BaseEntity {
    private String specifier;
    private BigDecimal odd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    @JsonIgnore
    @ToString.Exclude
    private Match match;
}
