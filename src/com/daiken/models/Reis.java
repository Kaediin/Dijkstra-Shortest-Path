package com.daiken.models;

import java.util.*;

public class Reis implements Comparable<Reis> {

    private Stap startStap;
    private Stap targetStap;

    public Reis(Stap startStap, Stap targetStap) {
        this.startStap = startStap;
        this.targetStap = targetStap;
    }

    public Stap getStartStap() {
        return startStap;
    }

    public void setStartStap(Stap startStap) {
        this.startStap = startStap;
    }

    public Stap getTargetStap() {
        return targetStap;
    }

    public void setTargetStap(Stap targetStap) {
        this.targetStap = targetStap;
    }

    @Override
    public int compareTo(Reis reis) {
        List<Stap> pathThis = this.compute();
        List<Stap> pathReis2 = reis.compute();
        double summedWeightThis, summedWeightReis2;
        summedWeightThis = pathThis.stream().mapToDouble(Stap::getGewicht).sum();
        summedWeightReis2 = pathReis2.stream().mapToDouble(Stap::getGewicht).sum();
        return Double.compare(summedWeightReis2, summedWeightThis);
    }

    public List<Stap> compute(){
        List<Stap> stappen = new ArrayList<>();
        Set<Stap> settledStappen = new HashSet<>();
        Set<Stap> unsettledStappen = new HashSet<>();
        unsettledStappen.add(this.getStartStap());
        while (unsettledStappen.size() != 0){
            Stap currentStap = getLowestDistanceStap(unsettledStappen);
            unsettledStappen.remove(currentStap);
            for (Stap stap: currentStap.getConnections()){
                if (!settledStappen.contains(stap)){
                    calculateMinimumDistance(stap, stap.getGewicht(), currentStap);
                    unsettledStappen.add(stap);
                }
            }
            settledStappen.add(currentStap);
            stappen.add(currentStap);

            if (currentStap == this.getTargetStap()){
                return stappen;
            }
        }
        return stappen;
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
