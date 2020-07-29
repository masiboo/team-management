package com.example.teammanagement.controller;

import com.example.teammanagement.model.Venue;
import com.example.teammanagement.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenueController {

    public static final String VENUE = "/venue";

    @Autowired
    private VenueRepository venueRepository;

    @PostMapping(VENUE)
    public ResponseEntity<?> addOrUpdate(@RequestBody Venue venue){
        Venue savedVenue = null;
        try {
            savedVenue = venueRepository.save(venue);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedVenue, HttpStatus.OK);
    }

    @GetMapping(VENUE)
    public List<Venue> getAll(){
        return  venueRepository.findAll();
    }


}
