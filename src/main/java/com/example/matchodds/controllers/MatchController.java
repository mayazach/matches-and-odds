package com.example.matchodds.controllers;

import com.example.matchodds.dto.MatchDto;
import com.example.matchodds.entities.Match;
import com.example.matchodds.enums.SportsEnum;
import com.example.matchodds.repos.MatchRepository;
import com.example.matchodds.service.MatchService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchRepository matchRepository;
    private final MatchService matchService;

    @Value("${max.result.size}")
    private Integer maxResultSize;

    public MatchController(MatchRepository matchRepository, MatchService matchService) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getMatches(@RequestParam(required = false) Integer page,
                                                  @RequestParam(required = false) Integer size) {
        int pageNumber = (page == null || page < 0 ? 0 : page);
        int pageSize = (size == null || size < 0 || size > maxResultSize ? maxResultSize : size);
        return ResponseEntity.ok(matchRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent());
    }

    @GetMapping(path = "/{matchId}")
    public ResponseEntity<Match> getMatch(@PathVariable Long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Match> postMatch(@Valid @RequestBody MatchDto match)
            throws BadRequestException {
        Match matchEntity = matchService.toMatchEntity(match);
        if (matchEntity.getSport().equals(SportsEnum.UNDEFINED)) {
            throw new BadRequestException("Sport must be FOOTBALL or BASKETBALL");
        }
        return new ResponseEntity<>(matchRepository.save(matchEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{matchId}")
    public ResponseEntity<Match> putMatch(@Valid @RequestBody MatchDto match, @PathVariable Long matchId)
            throws BadRequestException {
        Match matchEntity = matchService.toMatchEntity(match);
        return matchService.putMatch(matchId, matchEntity);
    }

    @DeleteMapping(path = "/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        matchRepository.deleteById(matchId);
        return ResponseEntity.noContent().build();
    }
}

