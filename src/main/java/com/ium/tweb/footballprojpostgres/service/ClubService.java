package com.ium.tweb.footballprojpostgres.service;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.exception.ClubException;
import com.ium.tweb.footballprojpostgres.exception.ClubNotFoundException;

import java.util.List;

/**
 * Service for Club entity.
 */
public interface ClubService {
    /**
     * Get all clubs.
     * @return List of all clubs.
     */
    List<Club> getAllClubs();

    /**
     * Get club by ID.
     * @param clubId ID of the club.
     * @return Club with the given ID.
     */
    Club getClubById(Integer clubId)  throws ClubNotFoundException;

    /**
     * Get clubs by domestic competition ID.
     * @param domesticCompetitionId ID of the domestic competition.
     * @return List of clubs in the given domestic competition.
     */
    List<Club> getClubsByDomesticCompetitionId(String domesticCompetitionId);

}
