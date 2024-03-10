package com.ium.tweb.footballprojpostgres.repository;

import com.ium.tweb.footballprojpostgres.data.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, String> {

    Competition findByCompetitionId(String competitionId);
    List<Competition> findByType(String type);

    List<Competition> findBySubType(String subType);

    List<Competition> findByCountryId(Integer countryId);

    List<Competition> findByCountryName(String countryName);

    List<Competition> findByConfederation(String confederation);

}

