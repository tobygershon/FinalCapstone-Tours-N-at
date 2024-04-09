package com.techelevator.dao.Tour.Model;

public class Route {

    private int routeId;
    private String startingPointId;
    private String endingPointId;
    private String polyline;

    public Route() {
    }

    public Route(int routeId, String startingPointId, String endingPointId, String polyline) {
        this.routeId = routeId;
        this.startingPointId = startingPointId;
        this.endingPointId = endingPointId;
        this.polyline = polyline;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getStartingPointId() {
        return startingPointId;
    }

    public void setStartingPointId(String startingPointId) {
        this.startingPointId = startingPointId;
    }

    public String getEndingPointId() {
        return endingPointId;
    }

    public void setEndingPointId(String endingPointId) {
        this.endingPointId = endingPointId;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }
}
