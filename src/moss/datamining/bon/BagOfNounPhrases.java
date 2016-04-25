package moss.datamining.bon;

import java.util.ArrayList;

import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

public class BagOfNounPhrases {

    public static ArrayList<Descriptor> descriptors;

    public BagOfNounPhrases() {
        descriptors = new ArrayList<Descriptor>();
    }

    public void findDesciptors(ArrayList<Document> documents) {
        for (Document document : documents) {
            ArrayList<Descriptor> theDescriptors = document.getDescriptors();
            for (Descriptor theDescriptor : theDescriptors) {
                boolean isAdded = false;
                String theName = theDescriptor.getName();
                int theDocumentNumber = theDescriptor.getDocumentNumber();
                for (Descriptor descriptor : descriptors) {
                    String name = descriptor.getName();
                    if (theName.equals(name)) {
                        int number = descriptor.getDocumentNumber() + theDescriptor.getDocumentNumber();
                        descriptor.setDocumentNumber(number);
                        descriptor.increaseDataNumber();
                        isAdded = true;
                    }
                }
                if (!isAdded) {
                    Descriptor descriptor = new Descriptor(theName, theDocumentNumber);
                    descriptors.add(descriptor);
                }
            }
        }
        //System.out.println("Descriptors : " + descriptors.size());
    }

}
