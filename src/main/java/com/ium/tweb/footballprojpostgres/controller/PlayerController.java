package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerNotFoundException;
import com.ium.tweb.footballprojpostgres.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rest/player")  /* Use request mapping for versioning */
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        try {
            List<Player> players = playerService.getAllPlayers();
            return ResponseEntity.ok(players);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") int playerId) {
        try {
            Player player = playerService.getPlayerById(playerId);
            return ResponseEntity.ok(player);
        }
        catch (PlayerNotFoundException e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{currentClubId}")
    public ResponseEntity<List<Player>> getPlayerByCurrentClubId(@PathVariable Integer currentClubId) {
        try {
            List<Player> players = playerService.getPlayerByCurrentClubId(currentClubId);
            return ResponseEntity.ok(players);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
    }


}

/*https://spring.io/guides/tutorials/rest*/


