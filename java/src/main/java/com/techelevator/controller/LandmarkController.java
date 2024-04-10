package com.techelevator.controller;

import com.techelevator.dao.Landmarks.JdbcLandmarkDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@CrossOrigin
public class LandmarkController {

//Fields for dependencies (services, jdbc's, other methods)
    private final LandmarkDao landmarkDao;

    public LandmarkController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

//    Need Get Request for List of all Places

    @GetMapping("/landmarks")
    public List<Landmark> getAllLandmarks() {
        return landmarkDao.getAllLandmarks();
    }
    
//    Need Get Request for List of Places by search criteria (times/days, proximity, category)

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

}
