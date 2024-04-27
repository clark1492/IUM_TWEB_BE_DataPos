package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.exception.ClubNotFoundException;
import com.ium.tweb.footballprojpostgres.repository.ClubRepository;
import com.ium.tweb.footballprojpostgres.service.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    private static final Logger logger = LoggerFactory.getLogger(ClubServiceImpl.class);
    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs;
    }

    @Override
    public Club getClubById(Integer clubId)  throws ClubNotFoundException{
        Club club = clubRepository.findByClubId(clubId);
        if (club == null) {
            String error = String.format("Club with id %d not found", clubId);
            logger.error(error);
            throw new ClubNotFoundException(error);
        }
        return club;
    }

    @Override
    public List<Club> getClubsByDomesticCompetitionId(String domesticCompetitionId) {
        List<Club> clubs = clubRepository.findByDomesticCompetitionId(domesticCompetitionId);
        return clubs;
    }

}
