package com.techelevator.controller;

import com.techelevator.dao.Landmarks.Model.Landmarks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SearchController {

//Fields for dependencies (services, jdbc's, other methods)

//    Need Get Request for List of all Places

    @GetMapping("/landmarks")
    public List<Landmarks> getAllLandmarks() {

        return null;
    }
//    Need Get Request for List of Places by search criteria (times/days, proximity, category)

    @GetMapping("/landmarks/{designation}")
    public List<Landmarks> getLandmarksByDesignation(@PathVariable String designation) {

        return null;
    }

    @GetMapping("/landmarks/{landmarkId}")
    public Landmarks getLandmarkById(@PathVariable int landmarkId) {

        return null;
    }


}
