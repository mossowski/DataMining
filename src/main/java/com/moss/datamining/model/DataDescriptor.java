package com.moss.datamining.model;

public class DataDescriptor {

    private String name;
    private int number;
    private int dataNumber;

    public DataDescriptor(String name, int number) {
        this.name = name;
        this.number = number;
        this.dataNumber = 1;
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

}

