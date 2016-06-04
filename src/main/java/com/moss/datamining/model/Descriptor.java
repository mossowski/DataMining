package com.moss.datamining.model;

import java.util.ArrayList;

public class Descriptor {

    private String name;
    private int number;
    private double weight;
    private ArrayList<String> pattern;

    public Descriptor(String name, int number, ArrayList<String> pattern) {
        this.name = name;
        this.number = number;
        this.weight = 0;
        this.setPattern(pattern);
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    // --------------------------------------------------------------------------------
    
    public void setName(String name) {
        this.name = name; 
    }

    // --------------------------------------------------------------------------------

    public int getNumber() {
        return number;
    }

    // --------------------------------------------------------------------------------

    public void setNumber(int number) {
        this.number = number;
    }

    // --------------------------------------------------------------------------------

    public void increaseNumber() {
        this.number++;
    }

    // --------------------------------------------------------------------------------

    public double getWeight() {
        return weight;
    }

    // --------------------------------------------------------------------------------

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // --------------------------------------------------------------------------------

    public ArrayList<String> getPattern() {
        return pattern;
    }

    // --------------------------------------------------------------------------------

    public void setPattern(ArrayList<String> pattern) {
        this.pattern = pattern;
    }

}
