package com.daiken.models;

import java.util.LinkedList;
import java.util.List;

public class Vlucht extends Stap {
    private double kosten;
    private double kansOpBagageVerlies = 0.05;

    public double getKansOpBagageVerlies() {
        return this.kansOpBagageVerlies;
    }

    public void setKansOpBagageVerlies(double kansOpBagageVerlies) {
        this.kansOpBagageVerlies = kansOpBagageVerlies;
    }

    public Vlucht(String name, float kosten, double kansOpBagageVerlies) {
        super(name);
        this.kosten = kosten;
        this.kansOpBagageVerlies = kansOpBagageVerlies;
        gewicht = this.getKosten();
    }


    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }
}
