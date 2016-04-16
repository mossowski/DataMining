package moss.datamining.model;

import java.util.ArrayList;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Document {

    public String name;
    public ArrayList<Element> document;
    public ArrayList<Descriptor> descriptors;

    // --------------------------------------------------------------------------------

    public Document() {
        document = new ArrayList<Element>();
        name = "";
        descriptors = new ArrayList<Descriptor>();
    }

    // --------------------------------------------------------------------------------

    public Document(ArrayList<Element> document, String name) {
        this.document = document;
        this.name = name;
        descriptors = new ArrayList<Descriptor>();
    }

    // --------------------------------------------------------------------------------

    public ArrayList<Element> getDocument() {
        return document;
    }

    // --------------------------------------------------------------------------------

    public void setDocument(ArrayList<Element> document) {
        this.document = document;
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints descriptors
     */
    public void printDescriptors() {
        System.out.println("--------------------------------");
        descriptors.forEach((e) -> System.out.println(e.name));
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints document
     */
    public void printDocument() {
        document.forEach((e) -> System.out.println(e.getWord() + " " + e.getPartOfSpeech()));
    }

}
