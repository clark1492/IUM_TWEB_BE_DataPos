package com.ium.tweb.footballprojpostgres.repository;

import com.ium.tweb.footballprojpostgres.data.model.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findAll();
    Player findByPlayerId(Integer playerId);
    List<Player> findByCurrentClubId(Integer currentClubId);

    List<Player> findByNameContaining(String name, Pageable pageable);

    List<Player> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
