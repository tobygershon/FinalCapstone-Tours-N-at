package com.techelevator.dao.Tour.Model;

import com.techelevator.service.models.Routes;

public class UpdateTourDTO {
    private int tourId;
    private Routes[] routes;

    public UpdateTourDTO(int tourId, Routes[] routes) {
        this.tourId = tourId;
        this.routes = routes;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Routes[] getRoutes() {
        return routes;
    }

    public void setRoutes(Routes[] routes) {
        this.routes = routes;
    }
}
