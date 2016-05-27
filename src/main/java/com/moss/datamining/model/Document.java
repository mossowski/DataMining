package com.moss.datamining.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Document {

    private String name;
    private ArrayList<Element> elements;
    private HashMap<String, Descriptor> descriptors;
    private int occurrenceNumber;

    // --------------------------------------------------------------------------------

    public Document() {
        name = "";
        elements = new ArrayList<Element>();
        descriptors = new HashMap<String, Descriptor>();
        occurrenceNumber = 0;
    }

    // --------------------------------------------------------------------------------

    public Document(ArrayList<Element> elements, String name) {
        this.name = name;
        this.elements = elements;
        descriptors = new HashMap<String, Descriptor>();
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    // --------------------------------------------------------------------------------

    public ArrayList<Element> getElements() {
        return elements;
    }

    // --------------------------------------------------------------------------------

    public HashMap<String, Descriptor> getDescriptors() {
        return descriptors;
    }

    // --------------------------------------------------------------------------------

    public void setDescriptors(HashMap<String, Descriptor> descriptors) {
        this.descriptors = descriptors;
    }

    // --------------------------------------------------------------------------------

    public int getOccurrenceNumber() {
        return occurrenceNumber;
    }

    // --------------------------------------------------------------------------------

    public int increaseOccurrenceNumber() {
        return occurrenceNumber++;
    }

}
