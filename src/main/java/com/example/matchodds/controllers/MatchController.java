package com.example.matchodds.controllers;

import com.example.matchodds.entities.Match;
import com.example.matchodds.repos.MatchRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchRepository matchRepository;

    @Value("${max.result.size}")
    private Integer maxResultSize;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
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

}

