package com.ium.tweb.footballprojpostgres.service.impl;

import com.ium.tweb.footballprojpostgres.data.model.Competition;
import com.ium.tweb.footballprojpostgres.exception.CompetitionNotFoundException;
import com.ium.tweb.footballprojpostgres.repository.CompetitionRepository;
import com.ium.tweb.footballprojpostgres.service.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private final CompetitionRepository competitionRepository;

    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> getAllCompetitions() {

        return competitionRepository.findAll();
    }

    @Override
    public Competition getCompetitionById(String competitionId) throws CompetitionNotFoundException {
        Competition competition = competitionRepository.findById(competitionId).orElse(null);
        if (competition == null) {
            String error = String.format("Competition with ID %s not found", competitionId);
            logger.error(error);
            throw new CompetitionNotFoundException(error);
        }
        else {
            return competition;
        }
    }

    @Override
    public List<Competition> getCompetitionsByType(String type) {
        return competitionRepository.findByType(type);
    }

    @Override
    public List<Competition> getCompetitionsBySubType(String subType) {
        return competitionRepository.findBySubType(subType);
    }

    @Override
    public List<Competition> getCompetitionsByCountryId(Integer countryId) {
        return competitionRepository.findByCountryId(countryId);
    }

    @Override
    public List<Competition> getCompetitionsByCountryName(String countryName) {
        return competitionRepository.findByCountryName(countryName);
    }

    @Override
    public List<Competition> getCompetitionsByConfederation(String confederation) {
        return competitionRepository.findByConfederation(confederation);
    }

}