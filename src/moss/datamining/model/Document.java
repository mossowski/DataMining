package moss.datamining.model;

import java.util.ArrayList;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Document {

    private String name;
    private ArrayList<Element> elements;
    private ArrayList<Descriptor> descriptors;

    // --------------------------------------------------------------------------------

    public Document() {
        name = "";
        elements = new ArrayList<Element>();
        descriptors = new ArrayList<Descriptor>();
    }

    // --------------------------------------------------------------------------------

    public Document(ArrayList<Element> elements, String name) {
        this.name = name;
        this.elements = elements;
        descriptors = new ArrayList<Descriptor>();
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

    public ArrayList<Descriptor> getDescriptors() {
        return descriptors;
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints descriptors
     */
    public void printDescriptors() {
        System.out.println("--------------------------------");
        descriptors.forEach((e) -> System.out.println(e.getName()));
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints document
     */
    public void printElements() {
        elements.forEach((e) -> System.out.println(e.getWord() + " " + e.getPartOfSpeech()));
    }

}
