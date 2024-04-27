package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerNotFoundException;

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
    Player getPlayerById(Integer playerId) throws PlayerNotFoundException;

    /**
     * Get players by current club ID.
     * @param currentClubId ID of the current club.
     * @return List of players with the given ID.
     */
    List<Player> getPlayerByCurrentClubId(Integer currentClubId);

}
