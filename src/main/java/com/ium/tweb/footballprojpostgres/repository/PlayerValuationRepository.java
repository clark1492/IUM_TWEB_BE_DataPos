package com.ium.tweb.footballprojpostgres.repository;

import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerValuationRepository extends JpaRepository<PlayerValuation, Long> {

    List<PlayerValuation> findPlayerValuationByIdPlayerId(Integer playerId);

    PlayerValuation findPlayerValuationByIdPlayerIdAndIdDate(Integer playerId, Date date);

    List<PlayerValuation> findPlayerValuationByCurrentClubId(Integer clubId);
}
