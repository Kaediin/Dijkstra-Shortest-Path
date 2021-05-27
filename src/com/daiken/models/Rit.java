package com.daiken.models;

public class Rit extends Stap{

    // private attribute kilometers
    private double kilometers;

    // Constructor
    public Rit(String name, double kilometers) {
        super(name);
        this.kilometers = kilometers;
        // for this object we use the kilometers as the weight
        this.setGewicht(kilometers);
    }

    // Getters and setters
    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }
}
