package com.techelevator.service.models.directions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Steps {

    @JsonProperty("html_instructions")
    private String htmlStep;

    public Steps() {
    }

    public Steps(String htmlStep) {
        this.htmlStep = htmlStep;
    }

    public String getHtmlStep() {
        return htmlStep;
    }

    public void setHtmlStep(String htmlStep) {
        this.htmlStep = htmlStep;
    }
}
