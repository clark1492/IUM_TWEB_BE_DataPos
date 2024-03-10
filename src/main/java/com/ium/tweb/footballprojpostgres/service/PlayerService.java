package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerException;
import org.springframework.stereotype.Service;

public interface PlayerService {
    /**
     * Get all players.
     * @return List of all players.
     */
    Player getPlayer(Integer playerId) throws PlayerException;
}
