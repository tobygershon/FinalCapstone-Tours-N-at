package com.techelevator.controller;

import com.techelevator.dao.Landmarks.JdbcLandmarkDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@CrossOrigin
public class SearchController {

//Fields for dependencies (services, jdbc's, other methods)
    private final LandmarkDao landmarkDao;

    public SearchController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

//    Need Get Request for List of all Places

    @GetMapping("/landmarks")
    public List<Landmark> getAllLandmarks() {
        return landmarkDao.getAllLandmarks();
    }
    
//    Need Get Request for List of Places by search criteria (times/days, proximity, category)

    @GetMapping("/landmarks/{designation}")
    public List<Landmark> getLandmarksByDesignation(@PathVariable String designation) {
        return landmarkDao.getLandmarksByDesignation(designation);
    }

    @GetMapping("/landmarks/{landmarkId}")
    public Landmark getLandmarkById(@PathVariable int landmarkId) {

        return landmarkDao.getLandmarkById(landmarkId);
    }


}
