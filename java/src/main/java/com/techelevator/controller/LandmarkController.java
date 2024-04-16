package com.techelevator.controller;

import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Designations;
import com.techelevator.dao.Landmarks.Model.Landmark;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LandmarkController {

    private final LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping("/landmarks")
    public List<Landmark> getAllLandmarks() {
        return landmarkDao.getAllLandmarks();
    }

    @GetMapping("/landmarks/{landmarkId}/designation")
    public List<Designations> getDesignationsForLandmark(@PathVariable Integer landmarkId){
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
        return landmarkDao.getLandmarkByName(landmarkName);
    }
    // getting designation by landmarks

//    List<Landmark> listOfLandmarks = landmarkDao.getLandmarkByName(landmarkName);
//
//        if (listOfLandmarks != null && listOfLandmarks.get(0).getLandmarkId() >0) {
//        return listOfLandmarks;
//    } else {
//        GeocodeResults result = geocodingService.getGeocodeInfo(landmarkName + "Pittsburgh");
//        if (result == null) {
//
//        } else {
//            Landmark landmark = new Landmark();
//            if (result.getResults()[0] != null) {
//                String placeId = result.getResults()[0].getPlaceId();
//                String placeAddress = result.getResults()[0].getAddress();
//                String placeName = placesService.getPlaceInfoByPlaceId(placeId).getName();
//                landmark.setLandmarkName(placeName);
//                landmark.setLandmarkId(placeId);
//                landmark.setAddress(placeAddress);
//
//            }
//        }
//        return returnObject;
//    }
//
//        return
//}
//// getting designation by landmarks


}

