package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.service.PlacesService;
import com.techelevator.service.models.places.PlacesResponse;
import com.techelevator.service.models.places.Result;
import com.techelevator.service.models.places.newPlacesDTO;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PlacesController {

    private final PlacesService placesService = new PlacesService();
    private final LandmarkDao landmarkDao;
    private final ItineraryDao itineraryDao;

    public PlacesController(LandmarkDao landmarkDao, ItineraryDao itineraryDao) {
        this.landmarkDao = landmarkDao;
        this.itineraryDao = itineraryDao;
    }

    @GetMapping("/places/{landmarkId}")
    public Result getPlaceInfoById(@PathVariable int landmarkId) {
         String placeId = landmarkDao.getPlaceIdByLandmarkId(landmarkId);

        return placesService.getPlaceInfoByPlaceId(placeId);
    }

    @GetMapping("/places/itineraries/{itineraryId}")
    public newPlacesDTO getDestinationUrlList(@PathVariable int itineraryId) {
        newPlacesDTO newPlacesDTO = new newPlacesDTO();
        List<String> urlList = new ArrayList<>();
        List<String> destinations = new ArrayList<>();

        List<String> resultList = itineraryDao.retrieveItineraryStops(itineraryId);

        for(int i = 1; i < resultList.size(); i++) {
            Result result = placesService.getPlaceInfoByPlaceId(resultList.get(i));
            String url = result.getUrl();
            urlList.add(url);
            String destinationName = result.getName();
            destinations.add(destinationName);
        }

        newPlacesDTO.setUrls(urlList);
        newPlacesDTO.setDestinations(destinations);

        return newPlacesDTO;
    }
}
