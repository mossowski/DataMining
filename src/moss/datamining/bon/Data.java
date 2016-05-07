package moss.datamining.bon;

import java.util.ArrayList;

import moss.datamining.model.Document;

public class Data {

    public static ArrayList<Document> documents = new ArrayList<Document>();

    // --------------------------------------------------------------------------------

    /**
     * Prints data
     */
    public void printDocuments() {
        documents.forEach((document) -> document.printElements());
    }

}
