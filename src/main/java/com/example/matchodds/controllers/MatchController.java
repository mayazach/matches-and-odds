package com.example.matchodds.controllers;

import com.example.matchodds.dto.MatchDto;
import com.example.matchodds.dto.MatchOddsDto;
import com.example.matchodds.entities.Match;
import com.example.matchodds.entities.MatchOdds;
import com.example.matchodds.enums.SportsEnum;
import com.example.matchodds.repos.MatchOddsRepository;
import com.example.matchodds.repos.MatchRepository;
import com.example.matchodds.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
@Tag(name = "Matches API")
public class MatchController {
    private final MatchRepository matchRepository;

    private final MatchOddsRepository matchOddsRepository;
    private final MatchService matchService;
    private final ModelMapper modelMapper;

    @Value("${max.result.size}")
    private Integer maxResultSize;

    public MatchController(MatchRepository matchRepository,
                           MatchService matchService, MatchOddsRepository matchOddsRepository) {
        this.matchRepository = matchRepository;
        this.matchService = matchService;
        this.modelMapper = new ModelMapper();
        this.matchOddsRepository = matchOddsRepository;
    }

    @Operation(summary = "Get matches with their odds", description = "Returns paginated results of stored matches")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    })
    @GetMapping
    public ResponseEntity<List<Match>> getMatches(@Parameter(name = "page", description = "Page number", example = "0")
                                                      @RequestParam(required = false) Integer page,
                                                  @Parameter(name = "size", description = "Page size (if larger than 500 set to 500)", example = "10")
                                                  @RequestParam(required = false) Integer size) {
        int pageNumber = (page == null || page < 0 ? 0 : page);
        int pageSize = (size == null || size < 0 || size > maxResultSize ? maxResultSize : size);
        return ResponseEntity.ok(matchRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent());
    }

    @Operation(summary = "Get a match by id", description = "Returns a match with odds as per the match id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
        @ApiResponse(responseCode = "404", description = "Not found - The match was not found")
    })
    @GetMapping(path = "/{matchId}")
    public ResponseEntity<Match> getMatch(@Parameter(name = "matchId", description = "Match id", example = "1")
                                              @PathVariable Long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new match entry")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid values")
    })
    public ResponseEntity<Match> postMatch(@Valid @RequestBody MatchDto match)
            throws BadRequestException {
        Match matchEntity = matchService.toMatchEntity(match);
        if (matchEntity.getSport().equals(SportsEnum.UNDEFINED)) {
            throw new BadRequestException("Sport must be FOOTBALL or BASKETBALL");
        }
        return new ResponseEntity<>(matchRepository.save(matchEntity), HttpStatus.CREATED);
    }

    @Operation(summary = "Update match entry", description = "Replaces match data of entry with given match id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid values"),
            @ApiResponse(responseCode = "404", description = "Not found - id does not exist")
    })
    @PutMapping(path = "/{matchId}")
    public ResponseEntity<Match> putMatch(@Valid @RequestBody MatchDto match,
                                          @Parameter(name = "matchId", description = "Match id", example = "1")
                                          @PathVariable Long matchId)
            throws BadRequestException {
        Match matchEntity = matchService.toMatchEntity(match);
        return matchService.putMatch(matchId, matchEntity);
    }

    @Operation(summary = "Delete match", description = "Deletes match with given id and its odds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted")
    })
    @DeleteMapping(path = "/{matchId}")
    public ResponseEntity<Void> deleteMatch(@Parameter(name = "matchId", description = "Match id", example = "1")
                                                @PathVariable Long matchId) {
        matchRepository.deleteById(matchId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Add new odds to match", description = "Creates new odds entry for match with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid values"),
            @ApiResponse(responseCode = "404", description = "Not found - match id does not exist")
    })
    @PostMapping(path = "/odds/{matchId}")
    public ResponseEntity<MatchOdds> postOdds(@Parameter(name = "matchId", description = "Match id", example = "1")
                                                  @PathVariable Long matchId, @RequestBody MatchOddsDto odds){
        MatchOdds matchOddsEntity = modelMapper.map(odds, MatchOdds.class);
        return matchService.postOdds(matchId, matchOddsEntity);
    }

    @Operation(summary = "Update odds entry", description = "Replaces data of odds entry with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid values"),
            @ApiResponse(responseCode = "404", description = "Not found - match id does not exist")
    })
    @PutMapping(path = "odds/{oddsId}")
    public ResponseEntity<MatchOdds> putMatch(@RequestBody MatchOddsDto odds,
                                              @Parameter(name = "oddsId", description = "Odds id", example = "1")
                                              @PathVariable Long oddsId) {
        MatchOdds matchOddsEntity = modelMapper.map(odds, MatchOdds.class);
        return matchService.putOdds(oddsId, matchOddsEntity);
    }

    @Operation(summary = "Delete odds entry", description = "Deletes odds entry with given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted")
    })
    @DeleteMapping(path = "odds/{oddsId}")
    public ResponseEntity<Void> deleteOdds(@Parameter(name = "oddsId", description = "Odds id", example = "1")
                                               @PathVariable Long oddsId) {
        matchOddsRepository.deleteById(oddsId);
        return ResponseEntity.noContent().build();
    }
}

