package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import com.ium.tweb.footballprojpostgres.exception.PlayerValuationNotFoundException;

import java.util.Date;
import java.util.List;

public interface PlayerValuationService {
    /**
     * Get all player valuations.
     * @return List of all player valuations.
     */
    List<PlayerValuation> getAllPlayerValuations();

    /**
     * Get player valuation by ID.
     * @param playerId ID of the player.
     * @param date date of the player valuation.
     * @return Player valuation with the given ID and date.
     */
    PlayerValuation getPlayerValuationsByPlayerIdAndDate(Integer playerId, Date date) throws PlayerValuationNotFoundException;

    /**
     * Get player valuations by player ID.
     * @param playerId ID of the player.
     * @return List of player valuations with the given ID.
     */
    List<PlayerValuation> getPlayerValuationsByPlayerId(Integer playerId);
    /**
     * Get player valuations by club ID.
     * @param clubId ID of the club.
     * @return List of player valuations with the given ID.
     */
    List<PlayerValuation> getPlayerValuationsByClubId(Integer clubId);
}

