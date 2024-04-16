package com.techelevator.controller;

import com.techelevator.dao.Itinerary.ItineraryDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.service.PlacesService;
import com.techelevator.service.models.places.PlacesResponse;
import com.techelevator.service.models.places.Result;
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
    public List<String> getDestinationUrlList(@PathVariable int itineraryId) {
        List<String> urlList = new ArrayList<>();

        List<String> result = itineraryDao.retrieveItineraryStops(itineraryId);

        for(int i = 1; i < result.size(); i++) {
            String url = placesService.getPlaceInfoByPlaceId(result.get(i)).getUrl();
            urlList.add(url);
        }

        return urlList;
    }
}
