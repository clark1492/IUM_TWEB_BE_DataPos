package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.Club;
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
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClubById(Integer clubId) {
        return clubRepository.findById(clubId).orElse(null);
    }

    @Override
    public List<Club> getClubsByDomesticCompetitionId(String domesticCompetitionId) {
        return clubRepository.findByDomesticCompetitionId(domesticCompetitionId);
    }

}
