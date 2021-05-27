package com.daiken.models;

public class Treinreis extends Stap {

    private int minuten;

    public Treinreis(String name, int minuten) {
        super(name);
        this.minuten = minuten;
        gewicht = minuten;
    }

    public Treinreis(int minuten) {
        this.minuten = minuten;
    }

    public int getMinuten() {
        return minuten;
    }

    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }
}
