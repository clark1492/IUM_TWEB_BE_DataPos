package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import com.ium.tweb.footballprojpostgres.exception.PlayerValuationNotFoundException;
import com.ium.tweb.footballprojpostgres.service.PlayerValuationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/rest/playerValuations")
public class PlayerValuationController {

    private final PlayerValuationService playerValuationService;

    private static final Logger logger = LoggerFactory.getLogger(PlayerValuationController.class);

    public PlayerValuationController(PlayerValuationService playerValuationService) {
        this.playerValuationService = playerValuationService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerValuation>> getAllPlayerValuations() {
        try {
            List<PlayerValuation> playersValuations = playerValuationService.getAllPlayerValuations();
            return ResponseEntity.ok(playersValuations);
        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<PlayerValuation>> getPlayerValuationsByPlayerId(@PathVariable Integer playerId) {
        try {
            List<PlayerValuation> playerValuations = playerValuationService.getPlayerValuationsByPlayerId(playerId);
            return ResponseEntity.ok(playerValuations);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/player/{playerId}/date/{date}")
    public ResponseEntity<PlayerValuation> getPlayerValuationsByPlayerId(@PathVariable Integer playerId, @PathVariable LocalDate date){

        try {
            PlayerValuation playerValuation = playerValuationService.getPlayerValuationsByPlayerIdAndDate(playerId, date);
            return ResponseEntity.ok(playerValuation);
        } catch (PlayerValuationNotFoundException e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/player/{playerId}/date/{date}")
    public ResponseEntity<PlayerValuation> deletePlayerValuationsByPlayerId(@PathVariable Integer playerId, @PathVariable LocalDate date){

            try {
                PlayerValuation playerValuation = playerValuationService.deletePlayerValuationsByPlayerIdAndDate(playerId, date);
                return ResponseEntity.ok(playerValuation);
            } catch (PlayerValuationNotFoundException e){
                logger.error(e.getMessage());
                return ResponseEntity.notFound().build();

            }
    }

    @PutMapping("/player/{playerId}/date/{date}")
    public ResponseEntity<PlayerValuation> updatePlayerValuationsByPlayerId(@PathVariable Integer playerId, @PathVariable LocalDate date, @RequestBody PlayerValuation playerValuation){
        try {
            PlayerValuation updatedPlayerValuation = playerValuationService.updatePlayerValuationsByPlayerIdAndDate(playerId, date, playerValuation);
            return ResponseEntity.ok(updatedPlayerValuation);
        } catch (PlayerValuationNotFoundException e){
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<PlayerValuation>> getPlayerValuationsByClubId(@PathVariable Integer clubId){

        try {
            List<PlayerValuation> playerValuation = playerValuationService.getPlayerValuationsByClubId(clubId);
            return ResponseEntity.ok(playerValuation);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();

        }
    }
}
