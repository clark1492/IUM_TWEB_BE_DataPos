package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import com.ium.tweb.footballprojpostgres.exception.PlayerValuationNotFoundException;

import java.util.Date;
import java.util.List;

public interface PlayerValuationService {
    PlayerValuation getPlayerValuationsByPlayerIdAndDate(Integer playerId, Date date) throws PlayerValuationNotFoundException;
    List<PlayerValuation> getPlayerValuationsByPlayerId(Integer playerId);
    List<PlayerValuation> getPlayerValuationsByClubId(Integer clubId);
}

