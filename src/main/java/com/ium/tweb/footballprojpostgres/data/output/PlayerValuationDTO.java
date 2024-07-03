package com.ium.tweb.footballprojpostgres.data.output;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.data.model.Player;
import com.ium.tweb.footballprojpostgres.data.model.PlayerValuation;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
public class PlayerValuationDTO {

    private Integer playerId;
    private String playerName;
    private Integer lastSeason;
    private LocalDateTime datetime;
    private LocalDate dateWeek;
    private Integer marketValueInEur;
    private Integer n;
    private Integer currentClubId;
    private String currentClubName;

    private String playerClubDomesticCompetitionId;

    public PlayerValuationDTO(Integer playerId, String playerName, Integer lastSeason, LocalDateTime datetime, LocalDate dateWeek, Integer marketValueInEur, Integer n, Integer currentClubId, String playerClubDomesticCompetitionId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.lastSeason = lastSeason;
        this.datetime = datetime;
        this.dateWeek = dateWeek;
        this.marketValueInEur = marketValueInEur;
        this.n = n;
        this.currentClubId = currentClubId;
        this.currentClubName = currentClubName;
        this.playerClubDomesticCompetitionId = playerClubDomesticCompetitionId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LocalDate getDateWeek() {
        return dateWeek;
    }

    public void setDateWeek(LocalDate dateWeek) {
        this.dateWeek = dateWeek;
    }

    public Integer getMarketValueInEur() {
        return marketValueInEur;
    }

    public void setMarketValueInEur(Integer marketValueInEur) {
        this.marketValueInEur = marketValueInEur;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getCurrentClubId() {
        return currentClubId;
    }

    public void setCurrentClubId(Integer currentClubId) {
        this.currentClubId = currentClubId;
    }

    public String getCurrentClubName() {
        return currentClubName;
    }

    public void setCurrentClubName(String currentClubName) {
        this.currentClubName = currentClubName;
    }

    public String getPlayerClubDomesticCompetitionId() {
        return playerClubDomesticCompetitionId;
    }

    public void setPlayerClubDomesticCompetitionId(String playerClubDomesticCompetitionId) {
        this.playerClubDomesticCompetitionId = playerClubDomesticCompetitionId;
    }
}*/
public class PlayerValuationDTO {
    private PlayerValuation playerValuation;
    private Player player;
    private Club club;

    // Constructor, getters and setters
    public PlayerValuationDTO(PlayerValuation playerValuation, Player player, Club club) {
        this.playerValuation = playerValuation;
        this.player = player;
        this.club = club;
    }

    public PlayerValuation getPlayerValuation() {
        return playerValuation;
    }

    public void setPlayerValuation(PlayerValuation playerValuation) {
        this.playerValuation = playerValuation;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
