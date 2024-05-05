package com.ium.tweb.footballprojpostgres.repository;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PlayerValuationRepository extends JpaRepository<PlayerValuation, Long> {


    List<PlayerValuation> findAll();

    List<PlayerValuation> findByIdPlayerId(Integer playerId);

    PlayerValuation findByIdPlayerIdAndIdDate(Integer playerId, LocalDate date);

    List<PlayerValuation> findByCurrentClubId(Integer clubId);
}
