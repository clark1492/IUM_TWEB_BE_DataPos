package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.exception.ClubException;
import com.ium.tweb.footballprojpostgres.exception.ClubNotFoundException;
import com.ium.tweb.footballprojpostgres.repository.ClubRepository;
import com.ium.tweb.footballprojpostgres.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> getAllClubs() throws ClubNotFoundException {
        List<Club> clubs = clubRepository.findAll();
        if (clubs.isEmpty()) {
            throw new ClubNotFoundException("No clubs found");
        } else {
            return clubs;
        }
    }

    @Override
    public Club getClubById(Integer clubId)  throws ClubNotFoundException{
        Club club = clubRepository.findByClubId(clubId);
        if (club == null) {
            throw new ClubNotFoundException("Club with id " + clubId + " not found");
        }
        return club;
    }

    @Override
    public List<Club> getClubsByDomesticCompetitionId(String domesticCompetitionId) throws ClubNotFoundException {
        List<Club> clubs = clubRepository.findByDomesticCompetitionId(domesticCompetitionId);
        if (clubs.isEmpty()) {
            throw new ClubNotFoundException("No clubs found for domestic competition with id " + domesticCompetitionId);
        } else {
            return clubs;
        }
    }

}
