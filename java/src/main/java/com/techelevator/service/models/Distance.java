package com.techelevator.service.models;

public class Distance {

    private String text;
//    private String value;

    public Distance() {
    }

    public Distance(String text) {
        this.text = text;
//        this.value = Integer.parseInt(value);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Integer getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = Integer.parseInt(value);
//    }
}
