package com.daiken.models;

import java.util.*;

public class Reis implements Comparable<Reis> {

    // private vars for the first and last step aka start and end -node
    private Stap startStap;
    private Stap targetStap;

    // Constructor
    public Reis(Stap startStap, Stap targetStap) {
        this.startStap = startStap;
        this.targetStap = targetStap;
    }

    // Getters and setters
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

    /**
     * @param reis the reis object you want to compare to
     * @return an integer. -1 being smaller; 0 being the same; 1 being larger
     */
    @Override
    public int compareTo(Reis reis) {
        Set<Stap> pathThis = this.compute();
        Set<Stap> pathReis2 = reis.compute();
        double summedWeightThis = pathThis.stream().mapToDouble(Stap::getGewicht).sum();
        double summedWeightReis2 = pathReis2.stream().mapToDouble(Stap::getGewicht).sum();
        return Double.compare(summedWeightReis2, summedWeightThis);
    }

    /**
     * Computes the path using drijkstra's algorithm
     * @return a set with the steps followed
     */
    public Set<Stap> compute(){
        // Create an empty list with steps and 2 empty sets
        Set<Stap> settledStappen = new HashSet<>();
        Set<Stap> unsettledStappen = new HashSet<>();
        // Add the first stap to the unsettled set as we start here
        unsettledStappen.add(this.getStartStap());
        // Run this while loop
        while (unsettledStappen.size() != 0){
            // Get the current step from the function which gets the closest node/step
            Stap currentStap = getLowestDistanceStap(unsettledStappen);
            // Remove from the unsettled list as this is the route we are now following
            unsettledStappen.remove(currentStap);
            // Loop through connections (other steps)
            for (Stap stap: currentStap.getConnections()){
                // If the list does not already contain this step we calculate the minimum distance to the other steps
                // and add those to the list
                if (!settledStappen.contains(stap)){
                    calculateMinimumDistance(stap, stap.getGewicht(), currentStap);
                    unsettledStappen.add(stap);
                }
            }
            // Add the current step to the list as this is the path we are following
            settledStappen.add(currentStap);
            // If the current step is the targer aka we are at the end we return the set
            if (currentStap == this.getTargetStap()){
                return settledStappen;
            }
        }
        // Return the set. This will only return here if the target step is not found in the path
        return settledStappen;
    }

    /**
     * Get the step that has the smallest distance (lowest weighting)
     * @param stappen the list with steps
     * @return the step with the lowest weight
     */
    private Stap getLowestDistanceStap(Set<Stap> stappen){
        // Create new step (null)
        Stap lowestStap = null;
        // Set default first value (max int value)
        double lowestStapDistance = Integer.MAX_VALUE;
        // loop through steps
        for (Stap stap : stappen){
            // Get the weight of the step
            double stapDistance = stap.getGewicht();
            // If the weight is lower than the stored weight (lowestStapDistance) this is now the new-lowest
            if (stapDistance < lowestStapDistance){
                lowestStapDistance = stapDistance;
                lowestStap = stap;
            }
        }
        return lowestStap;
    }

    /**
     * Calculate minimum distance to the node. The weight value of the step is the distance
     * @param evaluationStap the step we want to evaluate
     * @param weight the weight
     * @param sourceStap the first step
     */
    private void calculateMinimumDistance(Stap evaluationStap, double weight, Stap sourceStap){
        // get the weight of the source
        double sourceDistance = sourceStap.getGewicht();
        // If the weights added is less than the evaluation we set the values. Else we dont do anything
        if (sourceDistance + weight < evaluationStap.getGewicht()){
            evaluationStap.setGewicht(sourceDistance+weight);
            // Create empty linked list and add the source. We have visited that step already hence the addition
            LinkedList<Stap> shortestPath = new LinkedList<>(sourceStap.getShortestPath());
            shortestPath.add(sourceStap);
            evaluationStap.setShortestPath(shortestPath);
        }
    }
}
