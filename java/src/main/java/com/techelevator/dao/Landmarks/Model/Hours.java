package com.techelevator.dao.Landmarks.Model;

public class Hours {

    private int hoursId;
    private int landmarkId;
    private int dayOfWeek;
    private String openingTime;
    private String closingTime;

    public Hours(int hoursId, int landmarkId, int dayOfWeek, String openingTime, String closingTime) {
        this.hoursId = hoursId;
        this.landmarkId = landmarkId;
        this.dayOfWeek = dayOfWeek;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public int getHoursId() {
        return hoursId;
    }

    public void setHoursId(int hoursId) {
        this.hoursId = hoursId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
