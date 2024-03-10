package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.ClubGame;
import com.ium.tweb.footballprojpostgres.exception.ClubGameNotFoundException;
import com.ium.tweb.footballprojpostgres.service.ClubGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/rest/clubGames")
public class ClubGameController {

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    private final ClubGameService clubGameService;

    public ClubGameController(ClubGameService clubGameService) {
        this.clubGameService = clubGameService;
    }

    @GetMapping
    public List<ClubGame> getAllClubGames() {
        List<ClubGame> result = clubGameService.getAllClubGames();
        return result;
    }

    @GetMapping("/game/{gameId}")
    public List<ClubGame> getClubGamesByGameId(@PathVariable Integer gameId) {
        List<ClubGame> result =  clubGameService.getClubGamesByGameId(gameId);
        return result;
    }

    @GetMapping("/game/{gameId}/club/{clubId}")
    public ResponseEntity<ClubGame> getClubGamesByGameId(@PathVariable Integer gameId, @PathVariable Integer clubId) {
        try {
            ClubGame clubGame = clubGameService.getClubGamesByGameIdAndClubId(gameId, clubId);
            return ResponseEntity.ok(clubGame);
        } catch (ClubGameNotFoundException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/club/{clubId}")
    public List<ClubGame> getClubGamesByClubId(@PathVariable Integer clubId) {
        return clubGameService.getClubGamesByClubId(clubId);
    }

    @GetMapping("/opponent/{opponentId}")
    public List<ClubGame> getClubGamesByOpponentId(@PathVariable Integer opponentId) {
        return clubGameService.getClubGamesByOpponentId(opponentId);
    }

    @GetMapping("/hosting/{hosting}")
    public List<ClubGame> getClubGamesByHosting(@PathVariable String hosting) {
        return clubGameService.getClubGamesByHosting(hosting);
    }

}

