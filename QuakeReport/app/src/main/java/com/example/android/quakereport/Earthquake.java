package com.example.android.quakereport;

public class Earthquake {
    private String place;
    private double magnitude;
    private long date;

    public Earthquake(String place, double magnitude, long date) {
        this.place = place;
        this.magnitude = magnitude;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getDate() {
        return date;
    }
}
