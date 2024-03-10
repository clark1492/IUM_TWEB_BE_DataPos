package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.Competition;
import com.ium.tweb.footballprojpostgres.exception.CompetitionNotFoundException;
import com.ium.tweb.footballprojpostgres.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/rest/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{competitionId}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable String competitionId) {
        try {
            Competition competition = competitionService.getCompetitionById(competitionId);
            return ResponseEntity.ok(competition);
        } catch (CompetitionNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{type}")
    public List<Competition> getCompetitionsByType(@PathVariable String type) {
        return competitionService.getCompetitionsByType(type);
    }

}

