package com.example.matchodds.service;

import com.example.matchodds.dto.MatchDto;
import com.example.matchodds.entities.Match;
import com.example.matchodds.enums.SportsEnum;
import com.example.matchodds.repos.MatchRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public ResponseEntity<Match> putMatch (Long matchId, Match updatedMatch) throws BadRequestException {
        if (updatedMatch.getSport().equals(SportsEnum.UNDEFINED)) {
            throw new BadRequestException("Sport must be FOOTBALL or BASKETBALL");
        }
        Optional<Match> existingMatch = matchRepository.findById(matchId);
        if (existingMatch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            updatedMatch.setId(existingMatch.get().getId());
        }
        return new ResponseEntity<>(matchRepository.save(updatedMatch), HttpStatus.CREATED);
    }

    public Match toMatchEntity(MatchDto matchDto) {
        Match match = new Match();
        match.setDescription(matchDto.getDescription());
        match.setTeamA(matchDto.getTeamA());
        match.setTeamB(matchDto.getTeamB());
        match.setMatchDate(LocalDate.parse(matchDto.getMatchDate(), dateFormatter));
        match.setMatchTime(LocalTime.parse(matchDto.getMatchTime(), timeFormatter));
        match.setSport(matchDto.getSport());
        return match;
    }
}
