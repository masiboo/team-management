package com.example.teammanagement.controller;

import com.example.teammanagement.model.Player;
import com.example.teammanagement.model.Team;
import com.example.teammanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    public static final String TEAM = "/team";

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping(path = TEAM + "/{id}")
    public Team getById(@PathVariable(required = true) long id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    @PostMapping(TEAM)
    public ResponseEntity<?> addOrUpdate(@RequestBody Team team) {
        Team savedTeam = null;
        try {
            List<Player> players = team.getPlayers();
            team.getScore().setTeam(team);
            players.forEach( player -> player.setTeam(team));
            savedTeam = teamRepository.save(team);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedTeam, HttpStatus.OK);
    }

    @GetMapping(TEAM+"/all")
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @PutMapping(TEAM)
    public ResponseEntity<?> updateScore(@RequestBody Team team) {
        Team savedTeam = null;
        try {
            savedTeam = teamRepository.save(team);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedTeam, HttpStatus.OK);
    }

    @DeleteMapping(path = TEAM + "/{id}")
    public ResponseEntity<?> deleteScoreBoard(@PathVariable(required = true) long id) {
        try {
            teamRepository.deleteById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Team deleted successfully", HttpStatus.OK);
    }

}
