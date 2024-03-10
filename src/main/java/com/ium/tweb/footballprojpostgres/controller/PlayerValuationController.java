package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import com.ium.tweb.footballprojpostgres.exception.PlayerValuationNotFoundException;
import com.ium.tweb.footballprojpostgres.service.PlayerValuationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/playerValuations")
public class PlayerValuationController {

    private final PlayerValuationService playerValuationService;

    public PlayerValuationController(PlayerValuationService playerValuationService) {
        this.playerValuationService = playerValuationService;
    }


    @GetMapping("/player/{playerId}")
    public List<PlayerValuation> getPlayerValuationsByPlayerId(@PathVariable Integer playerId) {
        return playerValuationService.getPlayerValuationsByPlayerId(playerId);
    }
    
    @GetMapping("/player/{playerId}/date/{date}")
    public PlayerValuation getPlayerValuationsByPlayerId(@PathVariable Integer playerId, @PathVariable Date date) throws PlayerValuationNotFoundException {
        return playerValuationService.getPlayerValuationsByPlayerIdAndDate(playerId, date);
    }


    // Exception handler for PlayerValuationNotFoundException
    @ExceptionHandler(PlayerValuationNotFoundException.class)
    public ResponseEntity<Object> handlePlayerValuationNotFoundException(PlayerValuationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
