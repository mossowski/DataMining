package moss.datamining.model;

import java.util.ArrayList;

public class Data {

    private ArrayList<Document> documents;

    public Data() {
        documents = new ArrayList<Document>();
    }

    // --------------------------------------------------------------------------------

    public ArrayList<Document> getDocuments() {
        return this.documents;
    }

    // --------------------------------------------------------------------------------

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints data
     */
    public void printDocuments() {
        documents.forEach((document) -> document.printElements());
    }

}
