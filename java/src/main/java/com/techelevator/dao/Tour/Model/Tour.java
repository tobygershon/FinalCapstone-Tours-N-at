package com.techelevator.dao.Tour.Model;

public class Tour {

    private int tourId;
    private Route[] routes;

    public Tour(int tourId, Route[] routes) {
        this.tourId = tourId;
        this.routes = routes;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public void setRoutes(Route[] routes) {
        this.routes = routes;
    }
}
