package com.moss.datamining.model;

import java.util.ArrayList;

public class DataDescriptor {

    private String name;
    private String uniqueName;
    private ArrayList<String> similarNames;
    private int number;
    private int dataNumber;
    private ArrayList<String> files;
    private ArrayList<String> pattern;
    private boolean toRemove;

    public DataDescriptor(String name, int number, ArrayList<String> pattern) {
        this.name = name;
        this.uniqueName = null;
        this.number = number;
        this.dataNumber = 0;
        this.files = new ArrayList<String>();
        this.similarNames = new ArrayList<String>();
        this.setPattern(pattern);
        this.toRemove = false;
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
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

    public int getDataNumber() {
        return dataNumber;
    }

    // --------------------------------------------------------------------------------

    public void increaseDataNumber() {
        this.dataNumber++;
    }

    // --------------------------------------------------------------------------------

    public ArrayList<String> getFiles() {
        return files;
    }

    // --------------------------------------------------------------------------------

    public ArrayList<String> getPattern() {
        return pattern;
    }

    // --------------------------------------------------------------------------------

    public void setPattern(ArrayList<String> pattern) {
        this.pattern = pattern;
    }

    // --------------------------------------------------------------------------------

    public ArrayList<String> getSimilarNames() {
        return similarNames;
    }

    // --------------------------------------------------------------------------------

    public void setSimilarNames(ArrayList<String> similarNames) {
        this.similarNames = similarNames;
    }

    // --------------------------------------------------------------------------------

    public boolean isToRemove() {
        return toRemove;
    }

    // --------------------------------------------------------------------------------

    public void setToRemove(boolean toRemove) {
        this.toRemove = toRemove;
    }

    // --------------------------------------------------------------------------------

    public String getUniqueName() {
        return uniqueName;
    }

    // --------------------------------------------------------------------------------

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

}

