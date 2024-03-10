package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerException;
import com.ium.tweb.footballprojpostgres.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/rest/player")  /* Use request mapping for versioning */
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") int playerId) {
        try {
            Player player = playerService.getPlayer(playerId);
            return ResponseEntity.ok(player);
        }
        catch (PlayerException pe){
            return ResponseEntity.notFound().build();
        }
    }
}

/*https://spring.io/guides/tutorials/rest*/


