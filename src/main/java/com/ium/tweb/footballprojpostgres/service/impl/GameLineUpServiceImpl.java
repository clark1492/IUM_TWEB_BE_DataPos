package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.GameLineUp;
import com.ium.tweb.footballprojpostgres.exception.GameLineUpNotFoundException;
import com.ium.tweb.footballprojpostgres.repository.GameLineUpRepository;
import com.ium.tweb.footballprojpostgres.service.GameLineUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLineUpServiceImpl implements GameLineUpService {

  private static final Logger logger = LoggerFactory.getLogger(GameLineUpServiceImpl.class);

  private final GameLineUpRepository gameLineUpRepository;

  public GameLineUpServiceImpl(GameLineUpRepository gameLineUpRepository){ this.gameLineUpRepository = gameLineUpRepository; }

  @Override
  public List<GameLineUp> getAllGameLineUps(){
    List<GameLineUp> gameLineUps = gameLineUpRepository.findAll();
    return gameLineUps;
  }

  @Override
  public GameLineUp getGameLineUpById(String gameLineUpId) throws GameLineUpNotFoundException{
    GameLineUp gameLineUp = gameLineUpRepository.findByGameLineUpId(gameLineUpId);
    if(gameLineUp == null) {
      String error = String.format("GameLineUp with id %s not found",gameLineUpId);
      logger.error(error);
      throw new GameLineUpNotFoundException(error);
    }
    return gameLineUp;
  }

  @Override
  public List<GameLineUp> getGameLineUpByGameId(Integer gameId){
    List<GameLineUp> gameLineUps = gameLineUpRepository.findByGameId(gameId);
    return gameLineUps;
  }

  @Override
  public List<GameLineUp> getGameLineUpByClubId(Integer clubId){
    List<GameLineUp> gameLineUps = gameLineUpRepository.findByClubId(clubId);
    return gameLineUps;
  }

  @Override
  public List<GameLineUp> getGameLineUpByPlayerId(Integer playerId){
    List<GameLineUp> gameLineUps = gameLineUpRepository.findByPlayerId(playerId);
    return gameLineUps;
  }
}
