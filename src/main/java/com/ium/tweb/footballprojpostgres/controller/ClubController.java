package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.exception.ClubNotFoundException;
import com.ium.tweb.footballprojpostgres.service.ClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/rest/clubs")
public class ClubController {

    private final ClubService clubService;

    private static final Logger logger = LoggerFactory.getLogger(ClubController.class);

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs() {
        try {
            List<Club> clubs = clubService.getAllClubs();
            return ResponseEntity.ok(clubs);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{clubId}")
    public ResponseEntity<Club> getClubById(@PathVariable Integer clubId) {
        try {
            return ResponseEntity.ok(clubService.getClubById(clubId));
        }
        catch (ClubNotFoundException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/competition/{domesticCompetitionId}")
    public ResponseEntity<List<Club>> getClubsByDomesticCompetitionId(@PathVariable String domesticCompetitionId) {
        try {
            List<Club> clubs = clubService.getClubsByDomesticCompetitionId(domesticCompetitionId);
            return ResponseEntity.ok(clubs);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}

