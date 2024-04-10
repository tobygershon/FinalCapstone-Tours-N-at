package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Tour.Model.Route;
import com.techelevator.dao.Tour.Model.Tour;
import com.techelevator.dao.Tour.TourDao;
import com.techelevator.service.DirectionsService;
import com.techelevator.service.models.Directions;
import com.techelevator.service.models.DirectionsDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DirectionController {

    // need to get list of directions for each route in a tour
    private final DirectionsService directionsService;
    private final ItineraryDao itineraryDao;
    private final TourDao tourDao;

    public DirectionController(DirectionsService directionsService, ItineraryDao itineraryDao, TourDao tourDao) {
        this.directionsService = directionsService;
        this.itineraryDao = itineraryDao;
        this.tourDao = tourDao;
    }

    @GetMapping("/itineraries/{itineraryId}/directions")
    public DirectionsDTO getTourDirectionsList(@PathVariable int itineraryId) {
        DirectionsDTO newDTO = new DirectionsDTO();

        int tourId = itineraryDao.getTourIdFromItineraryId(itineraryId);

        Tour tour = tourDao.getTourById(tourId);

        List<Route> tourRoutesList = new ArrayList<>();

        for (Route route : tour.getRoutes()) {
            if (route)
        }


        Directions directions1 = directionsService.getDirections();
        Directions route2 =

        return newDTO;
    }

}
