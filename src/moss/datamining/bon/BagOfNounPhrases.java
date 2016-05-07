package moss.datamining.bon;

import java.util.HashMap;
import java.util.Map.Entry;

import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

import static moss.datamining.bon.Data.*;

public class BagOfNounPhrases {

    public static void findDataDesciptors() {
        for (Document document : documents.values()) {
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            for (Descriptor descriptor : descriptors.values()) {
                String descriptorName = descriptor.getName();
                int descriptorNumber = descriptor.getNumber();
                if(dataDescriptors.containsKey(descriptorName)) {
                    DataDescriptor dataDescriptor = dataDescriptors.get(descriptorName);
                    int number = descriptorNumber + dataDescriptor.getNumber();
                    dataDescriptor.setNumber(number);
                    dataDescriptor.increaseDataNumber();
                }
                else {
                    DataDescriptor dataDescriptor = new DataDescriptor(descriptorName, descriptorNumber);
                    dataDescriptors.put(descriptorName, dataDescriptor);
                }
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static void addDataDesciptors() {
        for (Document document : documents.values()) {
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            for (Entry<String, DataDescriptor> dataDescriptor : dataDescriptors.entrySet()) {
                String name = dataDescriptor.getKey();
                if (!descriptors.containsKey(name)) {
                    Descriptor descriptor = new Descriptor(name, 0);
                    descriptors.put(name, descriptor);
                }
            }
        }
    }

}
