package com.techelevator.dao.Landmarks;

import com.techelevator.dao.Landmarks.Model.Landmarks;

import java.util.List;

public interface LandmarksDao {

    Landmarks getLandmarkById(int id);
    List<Landmarks> getAllLandmarks();
    List<Landmarks> getLandmarksByDesignation(String landmarkDesignation);

}
