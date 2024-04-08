package com.techelevator.dao.Tour;

import com.techelevator.dao.Tour.Model.Route;
import com.techelevator.dao.Tour.Model.Tour;
import com.techelevator.dao.Tour.Model.UpdateTourDTO;

public interface TourDao {

    Tour getTourById(int id);

    Tour updateTour(UpdateTourDTO tour);

    Route getRouteById(int id);

    int getDistanceOfRoute(int startingPointId, int endingPointId);
}

