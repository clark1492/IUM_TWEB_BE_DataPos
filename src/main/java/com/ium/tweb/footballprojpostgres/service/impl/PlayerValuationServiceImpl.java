package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import com.ium.tweb.footballprojpostgres.exception.PlayerValuationNotFoundException;
import com.ium.tweb.footballprojpostgres.repository.PlayerValuationRepository;
import com.ium.tweb.footballprojpostgres.service.PlayerValuationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlayerValuationServiceImpl implements PlayerValuationService {


    private final PlayerValuationRepository playerValuationRepository;

    public PlayerValuationServiceImpl(PlayerValuationRepository playerValuationRepository) {
        this.playerValuationRepository = playerValuationRepository;
    }

    @Override
    public List<PlayerValuation> getAllPlayerValuations() {
        return playerValuationRepository.findAll();
    }

    @Override
    public List<PlayerValuation> getPlayerValuationsByPlayerId(Integer playerId) {
        return playerValuationRepository.findByIdPlayerId(playerId);
    }



    @Override
    public PlayerValuation getPlayerValuationsByPlayerIdAndDate(Integer playerId, Date date) throws PlayerValuationNotFoundException {
        PlayerValuation playerValuation = playerValuationRepository.findByIdPlayerIdAndIdDate(playerId, date);
        if (playerValuation == null) {
            throw new PlayerValuationNotFoundException("Player valuation not found for player ID: " + playerId + " and date: " + date);
        } else {
            return playerValuation;
        }
    }

    @Override
    public List<PlayerValuation> getPlayerValuationsByClubId(Integer clubId) {
       return playerValuationRepository.findByCurrentClubId(clubId);
    }

}
