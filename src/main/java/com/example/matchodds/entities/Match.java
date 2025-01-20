package com.example.matchodds.entities;

import com.example.matchodds.enums.SportsEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity(name = "match")
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match extends BaseEntity {
    @Column(name = "description")
    private String description;
    @Column(name = "match_date")
    private LocalDate matchDate;
    @Column(name = "match_time")
    private LocalTime matchTime;
    @Column(name = "team_a")
    private String teamA;
    @Column(name = "team_b")
    private String teamB;
    @Column(name = "sport")
    @Enumerated(EnumType.ORDINAL)
    @Schema(name = "Sport", description = "Football (FOOTBALL) or basketball (BASKETBALL)", example = "FOOTBALL")
    private SportsEnum sport;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Set<MatchOdds> matchOdds;
}
