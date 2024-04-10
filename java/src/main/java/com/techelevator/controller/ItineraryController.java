package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.UpdateItineraryDTO;
import com.techelevator.dao.User.UserDao;
import com.techelevator.dao.User.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ItineraryController {
    private final ItineraryDao itineraryDao;
    private final UserDao userDao;

    public ItineraryController(ItineraryDao itineraryDao, UserDao userDao) {
        this.itineraryDao = itineraryDao;
        this.userDao = userDao;
    }

    @GetMapping("/itineraries")
    public List<Itinerary> getItineraries(Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int loggedInUserId = loggedInUser.getId();

        return itineraryDao.getItinerariesByUserId(loggedInUserId);
    }

    @GetMapping("/itineraries/{itineraryId}")
    public Itinerary getItineraryById(@PathVariable int itineraryId) {
        return itineraryDao.getItineraryById(itineraryId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/itineraries")
    public Itinerary createItinerary(@RequestBody CreateItineraryDTO newItinerary) {
        return itineraryDao.createItinerary(newItinerary);
    }

    @PutMapping("/itineraries/{itineraryId}")
    public Itinerary updateItinerary(@RequestBody UpdateItineraryDTO itineraryToUpdate, @PathVariable int itineraryId) {
        return itineraryDao.updateItinerary(itineraryToUpdate);
    }

    @DeleteMapping("/itineraries/{itineraryId}")
    public void deleteItinerary(@PathVariable int itineraryId) {
        int rowsAffected = itineraryDao.deleteItinerary(itineraryId);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Itinerary not found.");
        }

    }

}
