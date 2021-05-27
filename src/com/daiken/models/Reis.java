package com.daiken.models;

import java.util.*;

public class Reis implements Comparable<Reis> {

    private List<Stap> stappen;

    public Reis() {
    }

    public Reis(List<Stap> stappen) {
        this.stappen = stappen;
    }

    public List<Stap> getStappen() {
        return stappen;
    }

    public void setStappen(List<Stap> stappen) {
        this.stappen = stappen;
    }

    @Override
    public int compareTo(Reis reis) {
        return this.getStappen().equals(reis.getStappen()) ? 1 : 0;
    }

    public void compute(Stap startStap, Stap targetStap){
        Set<Stap> settledStappen = new HashSet<>();
        Set<Stap> unsettledStappen = new HashSet<>();
        unsettledStappen.add(startStap);
        while (unsettledStappen.size() != 0){
            Stap currentStap = getLowestDistanceStap(unsettledStappen);
            unsettledStappen.remove(currentStap);
            for (Stap stap: currentStap.getConnections()){
                if (!settledStappen.contains(stap)){
                    calculateMinimumDistance(stap, stap.gewicht, currentStap);
                    unsettledStappen.add(stap);
                }
            }
            settledStappen.add(currentStap);
            if (currentStap == targetStap){
                System.out.println("Computed route: ");
                for (Stap stap : settledStappen){
                    System.out.println(stap.getName());
                }
                return;
            }
        }
    }

    private Stap getLowestDistanceStap(Set<Stap> stappen){
        Stap lowestStap = null;
        double lowestStapDistance = Integer.MAX_VALUE;
        for (Stap stap : stappen){
            double stapDistance = stap.getGewicht();
            if (stapDistance < lowestStapDistance){
                lowestStapDistance = stapDistance;
                lowestStap = stap;
            }
        }
        return lowestStap;
    }

    private void calculateMinimumDistance(Stap evaluationStap, double weight, Stap sourceStap){
        double sourceDistance = sourceStap.getGewicht();
        if (sourceDistance + weight < evaluationStap.getGewicht()){
            evaluationStap.setGewicht(sourceDistance+weight);
            LinkedList<Stap> shortestPath = new LinkedList<>(sourceStap.getShortestPath());
            shortestPath.add(sourceStap);
            evaluationStap.setShortestPath(shortestPath);
        }
    }
}
