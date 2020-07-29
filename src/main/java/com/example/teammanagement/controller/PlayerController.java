package com.example.teammanagement.controller;

import com.example.teammanagement.model.Player;
import com.example.teammanagement.repository.PlayerRepository;
import com.example.teammanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    public static final String PLAYER = "/player";

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping(path = PLAYER + "/{id}")
    public Player getById(@PathVariable(required = true) long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.orElse(null);
    }

    @PostMapping(PLAYER)
    public ResponseEntity<?> addOrUpdate(@RequestBody Player player) {
        Player savedPlayer = null;
        try {
            savedPlayer = playerRepository.save(player);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping(PLAYER+"/all")
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @PutMapping(PLAYER)
    public ResponseEntity<?> updateScore(@RequestBody Player player) {
        Player savedPlayer = null;
        try {
            savedPlayer = playerRepository.save(player);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @DeleteMapping(PLAYER + "/{id}")
    public ResponseEntity<?> deleteScoreBoard(@PathVariable(required = true) long id) {
        try{
            playerRepository.deleteById(id);
        } catch (Exception ex) {
            return new ResponseEntity<>("Score not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Score deleted successfully", HttpStatus.OK);
    }
}
