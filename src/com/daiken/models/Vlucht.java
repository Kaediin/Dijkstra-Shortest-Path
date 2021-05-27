package com.daiken.models;

public class Vlucht extends Stap {

    // Object attibutes
    private double kosten;
    private double kansOpBagageVerlies = 0.05;

    // Constructor
    public Vlucht(String name, float kosten, double kansOpBagageVerlies) {
        super(name);
        this.kosten = kosten;
        this.kansOpBagageVerlies = kansOpBagageVerlies;
        // As weight we use the cost multiplied by the % chance of bagageloss
        this.setGewicht(this.getKosten()*this.kansOpBagageVerlies);
    }

    // Getters and setters
    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public double getKansOpBagageVerlies() {
        return this.kansOpBagageVerlies;
    }

    public void setKansOpBagageVerlies(double kansOpBagageVerlies) {
        this.kansOpBagageVerlies = kansOpBagageVerlies;
    }
}
