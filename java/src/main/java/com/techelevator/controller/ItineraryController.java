package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.AddOrDeleteLandmarkDTO;
import com.techelevator.dao.User.UserDao;
import com.techelevator.dao.User.model.User;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.PlacesService;
import com.techelevator.service.models.geocoder.GeocodeResults;
import com.techelevator.service.models.geocoder.Results;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ItineraryController {
    private final ItineraryDao itineraryDao;
    private final UserDao userDao;
    private final GeocodingService geocodingService = new GeocodingService();
    private final PlacesService placesService = new PlacesService();

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
    public Itinerary createItinerary(@RequestBody CreateItineraryDTO newItinerary, Principal principal) {
        Itinerary returnObject = null;
        User user = userDao.getUserByUsername(principal.getName()); //is this needed?

        GeocodeResults result = geocodingService.getGeocodeInfo(newItinerary.getStartingLocation());
        if (result == null) {

        } else {
            if (result.getResults()[0] != null) {
                String placeId = result.getResults()[0].getPlaceId();
                String placeAddress = result.getResults()[0].getAddress();
                String placeName = placesService.getPlaceInfoByPlaceId(placeId).getName();
                newItinerary.setStartingLocation(placeName);

                returnObject = itineraryDao.createItinerary(newItinerary, principal, placeId, placeAddress);
            }
        }
        return returnObject;
    }

    @PutMapping("/landmarks/{landmarkId}/{itineraryId}")
    public Itinerary addLandmarkToItinerary(@RequestBody AddOrDeleteLandmarkDTO itineraryToUpdate, @PathVariable int landmarkId, @PathVariable int itineraryId) {
        itineraryDao.addLandmarkToItinerary(itineraryToUpdate);
        return getItineraryById(itineraryId);
    }

    @PutMapping("/itineraries/{itineraryId}")
    public Itinerary updateItinerary(@RequestBody Itinerary itineraryToUpdate, @PathVariable int itineraryId) {
        itineraryDao.updateItinerary(itineraryToUpdate);
        Itinerary updatedItinerary = itineraryDao.getItineraryById(itineraryToUpdate.getItineraryId());
        return updatedItinerary;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/itineraries/{itineraryId}")
    public void deleteItinerary(@PathVariable int itineraryId) {
        itineraryDao.deleteItinerary(itineraryId);
    }

}
