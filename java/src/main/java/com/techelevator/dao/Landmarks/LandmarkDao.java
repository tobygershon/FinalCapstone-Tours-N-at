package com.techelevator.dao.Landmarks;

import com.techelevator.dao.Landmarks.Model.Landmark;

import java.util.List;

public interface LandmarkDao {

    Landmark getLandmarkById(int id);
    Landmark getLandmarkByName(String landmarkName);
    List<Landmark> getAllLandmarks();
    List<Landmark> getLandmarksByDesignation(String landmarkDesignation);

}
