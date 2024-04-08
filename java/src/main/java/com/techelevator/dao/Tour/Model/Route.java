package com.techelevator.dao.Tour.Model;

public class Route {

    private int routeId;
    private int startingPointId;
    private int endingPointId;
    private String polyline;

    public Route(int routeId, int startingPointId, int endingPointId, String polyline) {
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

    public int getStartingPointId() {
        return startingPointId;
    }

    public void setStartingPointId(int startingPointId) {
        this.startingPointId = startingPointId;
    }

    public int getEndingPointId() {
        return endingPointId;
    }

    public void setEndingPointId(int endingPointId) {
        this.endingPointId = endingPointId;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }
}
