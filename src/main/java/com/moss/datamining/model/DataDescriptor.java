package com.moss.datamining.model;

import java.util.ArrayList;

public class DataDescriptor {

    private String name;
    private int number;
    private int dataNumber;
    private ArrayList<String> files;
    private ArrayList<String> pattern;

    public DataDescriptor(String name, int number, ArrayList<String> pattern) {
        this.name = name;
        this.number = number;
        this.dataNumber = 1;
        this.files = new ArrayList<String>();
        this.setPattern(pattern);
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

}

