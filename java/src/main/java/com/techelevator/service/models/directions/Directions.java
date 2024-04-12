package com.techelevator.service.models.directions;

public class Directions {

    private Routes[] routes;

    public Directions() {
    }

    public Directions(Routes[] routes) {
        this.routes = routes;
    }

    public Routes[] getRoutes() {
        return routes;
    }

    public void setRoutes(Routes[] routes) {
        this.routes = routes;
    }
}
