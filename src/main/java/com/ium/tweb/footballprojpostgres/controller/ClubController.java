package com.ium.tweb.footballprojpostgres.controller;

import com.ium.tweb.footballprojpostgres.data.model.Club;
import com.ium.tweb.footballprojpostgres.service.ClubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/rest/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{clubId}")
    public Club getClubById(@PathVariable Integer clubId) {
        return clubService.getClubById(clubId);
    }

    @GetMapping("/competition/{domesticCompetitionId}")
    public List<Club> getClubsByDomesticCompetitionId(@PathVariable String domesticCompetitionId) {
        return clubService.getClubsByDomesticCompetitionId(domesticCompetitionId);
    }

}

