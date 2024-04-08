package com.techelevator.service.models;

import org.springframework.util.RouteMatcher;

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
