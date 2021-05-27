package com.daiken.models;

public class Rit extends Stap{

    private double kilometers;

    public Rit(String name, double kilometers) {
        super(name);
        this.kilometers = kilometers;
        this.setGewicht(kilometers);
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public Rit() {
    }
}
