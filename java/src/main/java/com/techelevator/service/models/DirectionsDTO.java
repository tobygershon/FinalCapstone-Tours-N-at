package com.techelevator.service.models;

import java.util.ArrayList;
import java.util.List;

public class DirectionsDTO {

    private List<Routes> routes;

    public DirectionsDTO() {
    }

    public DirectionsDTO(List<Routes> routes) {
        this.routes = routes;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
}
