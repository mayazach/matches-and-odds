package com.example.matchodds.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Entity(name = "match")
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "match_date")
    private LocalDate matchDate;
    @Column(name = "team_a")
    private String teamA;
    @Column(name = "team_b")
    private String teamB;
}
