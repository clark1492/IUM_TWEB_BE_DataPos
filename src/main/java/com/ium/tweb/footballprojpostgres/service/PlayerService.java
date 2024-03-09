package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.exception.PlayerException;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    Player getPlayer(Integer playerId) throws PlayerException;
}
