package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.dao.Tour.Model.Route;
import com.techelevator.dao.Tour.Model.Tour;
import com.techelevator.dao.Tour.TourDao;
import com.techelevator.service.DirectionsService;
import com.techelevator.service.models.directions.Directions;
import com.techelevator.service.models.directions.DirectionsDTO;
import com.techelevator.service.models.directions.Routes;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final DirectionsService directionsService = new DirectionsService();
    private final ItineraryDao itineraryDao;
    private final TourDao tourDao;
    private final LandmarkDao landmarkDao;

    public DirectionController(ItineraryDao itineraryDao, TourDao tourDao, LandmarkDao landmarkDao) {
        this.itineraryDao = itineraryDao;
        this.tourDao = tourDao;
        this.landmarkDao = landmarkDao;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/directions/{itineraryId}")
    public DirectionsDTO getTourDirectionsList(@PathVariable int itineraryId) {
        DirectionsDTO newDTO = new DirectionsDTO();

        int tourId = itineraryDao.getTourIdFromItineraryId(itineraryId);

        Tour tour = tourDao.getTourById(tourId);

        List<Routes> tourRoutesList = new ArrayList<>();

        for (Route route : tour.getRoutes()) {
            if (route != null) {
                Landmark start = landmarkDao.getLandmarkById(route.getStartingPointId());
                Landmark end = landmarkDao.getLandmarkById(route.getEndingPointId());

                Directions newDirections = directionsService.getDirections(start.getGooglePlaceId(), end.getGooglePlaceId());
                tourRoutesList.add(newDirections.getRoutes()[0]);
                //routes[0] bc only 1 ist returned
            }
        }

        newDTO.setRoutes(tourRoutesList);


        return newDTO;
    }

}
