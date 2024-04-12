package com.techelevator.service.models.directions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Routes {

    private Legs[] legs;
    @JsonProperty("overview_polyline")
    private PolylineOverview polylineOverview;

    public Routes() {
    }

    public Routes(Legs[] legs, PolylineOverview polylineOverview) {
        this.legs = legs;
        this.polylineOverview = polylineOverview;
    }

    public Legs[] getLegs() {
        return legs;
    }

    public void setLegs(Legs[] legs) {
        this.legs = legs;
    }

    public PolylineOverview getPolylineOverview() {
        return polylineOverview;
    }

    public void setPolylineOverview(PolylineOverview polylineOverview) {
        this.polylineOverview = polylineOverview;
    }
}
