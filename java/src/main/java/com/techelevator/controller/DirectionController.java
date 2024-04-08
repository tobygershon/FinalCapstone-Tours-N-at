package com.techelevator.controller;

import com.techelevator.service.models.Directions;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DirectionController {

    // need to get list of directions for each route in a tour

    @GetMapping("/itineraries/{itineraryId}/directions")
    public List<Directions> getTourDirectionsList(@PathVariable int itineraryId) {

        return null;
    }

}
