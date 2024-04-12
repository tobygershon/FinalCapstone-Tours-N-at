package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Photos {

    @JsonProperty("photo_reference")
    private String photoReference;

    public Photos() {
    }

    public Photos(String photoReference) {
        this.photoReference = photoReference;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }
}
