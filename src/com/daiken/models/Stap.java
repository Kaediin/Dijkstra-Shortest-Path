package com.daiken.models;

import java.util.LinkedList;
import java.util.List;

public class Stap {

    private String name;
    public double gewicht;
    private List<Stap> connections;
    private LinkedList<Stap> shortestPath = new LinkedList<>();

    public LinkedList<Stap> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Stap> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Stap> getConnections() {
        return connections;
    }

    public void setConnections(List<Stap> connections) {
        this.connections = connections;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public Stap(String name) {
        this.name = name;
    }

    public Stap() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
