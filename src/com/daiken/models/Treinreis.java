package com.daiken.models;

public class Treinreis extends Stap {

    // Object attibutes
    private int minuten;

    // Constructor
    public Treinreis(String name, int minuten) {
        super(name);
        this.minuten = minuten;
        // We use the minutes as weights
        this.setGewicht(minuten);
    }

    // Getters and setters
    public int getMinuten() {
        return minuten;
    }

    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }
}
