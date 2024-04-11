package com.techelevator.controller;

import com.techelevator.dao.Landmarks.LandmarkDao;
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

    @GetMapping("/landmarks/designation/{designation}")
    public List<Landmark> getLandmarksByDesignation(@PathVariable String designation) {
        return landmarkDao.getLandmarksByDesignation(designation);
    }
    @GetMapping("/designations")
    public List<String> getAllDesignations() {
        return landmarkDao.getAllDesignations();
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