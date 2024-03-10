package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerException;
import com.ium.tweb.footballprojpostgres.repository.PlayerRepository;
import com.ium.tweb.footballprojpostgres.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);
    private final PlayerRepository playerRepository;

    /* Using constructor injection */
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players;
    }

    @Override
    public Player getPlayer(Integer playerId) throws PlayerException {
        Player player = playerRepository.getPlayerByPlayerId(playerId);
        if (player == null) {
            logger.error(String.format("Not Existing Player (playerId = %d)", playerId));
            throw new PlayerException("Not Existing Player");
        } else {
            return player;
        }
    }

}
