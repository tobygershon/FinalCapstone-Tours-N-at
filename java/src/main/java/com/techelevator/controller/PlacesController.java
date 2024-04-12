package com.techelevator.controller;

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

@RestController
@CrossOrigin
public class PlacesController {

    private final PlacesService placesService = new PlacesService();
    private final LandmarkDao landmarkDao;

    public PlacesController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping("/places/{landmarkId}")
    public Result getPlaceInfoById(@PathVariable int landmarkId) {
         String placeId = landmarkDao.getPlaceIdByLandmarkId(landmarkId);

        return placesService.getPlaceInfoByPlaceId(placeId);
    }
}
