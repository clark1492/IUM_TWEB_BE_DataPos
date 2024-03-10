package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerException;

import java.util.List;

public interface PlayerService {
    /**
     * Get all players.
     * @return List of all players.
     */
    List<Player> getAllPlayers();

    /**
     * Get player by ID.
     * @param playerId ID of the player.
     * @return Player with the given ID.
     */
    Player getPlayer(Integer playerId) throws PlayerException;
}
