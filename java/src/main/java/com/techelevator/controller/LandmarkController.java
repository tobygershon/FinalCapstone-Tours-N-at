package com.techelevator.controller;

import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Designations;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.PlacesService;
import com.techelevator.service.models.geocoder.GeocodeResults;
import com.techelevator.service.models.places.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LandmarkController {

    private final LandmarkDao landmarkDao;
    private final GeocodingService geocodingService = new GeocodingService();
    private final PlacesService placesService = new PlacesService();

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping("/landmarks")
    public List<Landmark> getAllLandmarks() {
        return landmarkDao.getAllLandmarks();
    }

    @GetMapping("/landmarks/{landmarkId}/designation")
    public List<Designations> getDesignationsForLandmark(@PathVariable Integer landmarkId) {
        if (landmarkId == null) {
            throw new IllegalArgumentException("Landmark ID must not be null");
        }
        return landmarkDao.getDesignationsForLandmark(landmarkId);
    }

    @GetMapping("/landmarks/designation/{designation}")
    public List<Landmark> getLandmarksByDesignation(@PathVariable String designation) {
        return landmarkDao.getLandmarksByDesignation(designation);
    }

    @GetMapping("/landmarks/{landmarkId}")
    public Landmark getLandmarkById(@PathVariable int landmarkId) {
        return landmarkDao.getLandmarkById(landmarkId);
    }

    @GetMapping("/landmarks/search/{landmarkName}")
    public List<Landmark> searchLandmarksByName(@PathVariable String landmarkName) {
        List<Landmark> listOfLandmarks = landmarkDao.getLandmarkByName(landmarkName);

        if (listOfLandmarks != null && listOfLandmarks.size() > 0) {
            return listOfLandmarks;
        } else {
            GeocodeResults geocodeResult = geocodingService.getGeocodeInfo(landmarkName);
            if (geocodeResult == null) {

            } else {
                Landmark landmark = new Landmark();
                if (geocodeResult.getResults()[0] != null) {
                    String placeId = geocodeResult.getResults()[0].getPlaceId();
                    String placeAddress = geocodeResult.getResults()[0].getAddress();
                    Result placesResult = placesService.getPlaceInfoByPlaceId(placeId);
                    String placeName = placesResult.getName();
                    landmark.setLandmarkName(placeName);
                    landmark.setGooglePlaceId(placeId);
                    landmark.setAddress(placeAddress);
                    int landmarkId = landmarkDao.createNewLandmark(landmark);
                    listOfLandmarks.add(landmarkDao.getLandmarkById(landmarkId));
                }
            }
            return listOfLandmarks;
        }

    }

}

