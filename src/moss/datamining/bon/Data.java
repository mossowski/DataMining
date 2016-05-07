package moss.datamining.bon;

import java.util.HashMap;

import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Document;

public class Data {

    public static HashMap<String, Document> documents = new HashMap<String, Document>();
    public static HashMap<String, DataDescriptor> dataDescriptors = new HashMap<String, DataDescriptor>();

    // --------------------------------------------------------------------------------

    public static void cleanData() {
        documents.clear();
        dataDescriptors.clear();
    }

}
