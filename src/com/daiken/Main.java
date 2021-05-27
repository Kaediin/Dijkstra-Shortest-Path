package com.daiken;

import com.daiken.models.Reis;
import com.daiken.models.Rit;
import com.daiken.models.Treinreis;
import com.daiken.models.Vlucht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vlucht> vluchten = new ArrayList<>(Arrays.asList(
                new Vlucht("Parijs", 200, 0.18),
                new Vlucht("Barcelona", 150, 0.05),
                new Vlucht("Londen",  230, 0.11),
                new Vlucht("Berlijn", 340, 0.03),
                new Vlucht("Milaan" , 160, 0.02)
        ));
        vluchten.get(0).setConnections(Arrays.asList(vluchten.get(1), vluchten.get(4)));
        vluchten.get(1).setConnections(Arrays.asList(vluchten.get(4), vluchten.get(3)));
        vluchten.get(2).setConnections(Arrays.asList(vluchten.get(1), vluchten.get(3)));
        vluchten.get(3).setConnections(Arrays.asList(vluchten.get(2), vluchten.get(0)));
        vluchten.get(4).setConnections(Arrays.asList(vluchten.get(3), vluchten.get(2)));

        List<Rit> ritten = new ArrayList<>(Arrays.asList(
                new Rit("A1", 80),
                new Rit("A2", 60),
                new Rit("A6", 75),
                new Rit("A10", 120),
                new Rit("A27", 50)
        ));
        ritten.get(0).setConnections(Arrays.asList(ritten.get(2), ritten.get(3)));
        ritten.get(1).setConnections(Arrays.asList(ritten.get(2), ritten.get(4)));
        ritten.get(2).setConnections(Arrays.asList(ritten.get(1), ritten.get(3)));
        ritten.get(3).setConnections(Arrays.asList(ritten.get(2), ritten.get(0)));
        ritten.get(4).setConnections(Arrays.asList(ritten.get(0), ritten.get(1)));

        List<Treinreis> treinreizen = new ArrayList<>(Arrays.asList(
                new Treinreis("Almere", 25),
                new Treinreis("Utrecht", 15),
                new Treinreis("Amsterdam", 45),
                new Treinreis("Arhnem", 30),
                new Treinreis("Den Haag", 60)
        ));
        treinreizen.get(0).setConnections(Arrays.asList(treinreizen.get(1), treinreizen.get(4)));
        treinreizen.get(1).setConnections(Arrays.asList(treinreizen.get(4), treinreizen.get(3)));
        treinreizen.get(2).setConnections(Arrays.asList(treinreizen.get(1), treinreizen.get(3)));
        treinreizen.get(3).setConnections(Arrays.asList(treinreizen.get(2), treinreizen.get(0)));
        treinreizen.get(4).setConnections(Arrays.asList(treinreizen.get(3), treinreizen.get(2)));

        Reis reis = new Reis();
        reis.compute(vluchten.get(4), vluchten.get(0));
        reis.compute(ritten.get(0), ritten.get(3));
        reis.compute(treinreizen.get(1), treinreizen.get(0));
    }
}
