package com.techelevator.controller;

import com.techelevator.dao.Itinerary.Model.Itinerary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ItineraryController {

//Fields for dependencies (services, jdbc's, other methods)


//    Need a Get Request for a list of itineraries for a user
    @GetMapping("/itineraries/{userId}")
    public List<Itinerary> getItinerariesByUserId(@PathVariable int userId) {

        return null;
    }

//    Need a Get Request for a specific itinerary
    @GetMapping("/itineraries/{itineraryId}")
    public Itinerary getItineraryById(@PathVariable int itineraryId) {

        return null;
    }

//    Need a Post Request to create itinerary
    @PostMapping("/itineraries")
    public Itinerary createItinerary(@RequestBody Itinerary newItinerary) {

        return null;
    }

//    Need an Update Request to update itinerary
    @PutMapping("/itineraries/{itineraryId")
    public Itinerary updateItinerary(@RequestBody Itinerary itineraryToUpdate, @PathVariable int itineraryId) {

        return null;
    }

//    Need a delete Request to delete itinerary
    @DeleteMapping("itineraries/{itineraryId}")
    public void deleteItinerary(@PathVariable int itineraryId) {

    }

    //    Need a Get Request for Directions
}
