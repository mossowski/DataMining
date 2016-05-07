package moss.datamining.bon;

import java.util.ArrayList;

import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

import static moss.datamining.bon.Data.*;

public class BagOfNounPhrases {

    public static ArrayList<DataDescriptor> dataDescriptors = new ArrayList<DataDescriptor>();

    public static void findDataDesciptors() {
        for (Document document : documents) {
            ArrayList<Descriptor> descriptors = document.getDescriptors();
            for (Descriptor descriptor : descriptors) {
                boolean isAdded = false;
                String descriptorName = descriptor.getName();
                int descriptorNumber = descriptor.getNumber();
                for (DataDescriptor dataDescriptor : dataDescriptors) {
                    String name = dataDescriptor.getName();
                    if (descriptorName.equals(name)) {
                        int number = descriptor.getNumber() + dataDescriptor.getNumber();
                        dataDescriptor.setNumber(number);
                        dataDescriptor.increaseDataNumber();
                        isAdded = true;
                    }
                }
                if (!isAdded) {
                    DataDescriptor dataDescriptor = new DataDescriptor(descriptorName, descriptorNumber);
                    dataDescriptors.add(dataDescriptor);
                }
            }
        }
    }

    public static void addDataDesciptors() {
        for (Document document : documents) {
            ArrayList<Descriptor> descriptors = document.getDescriptors();
            for (DataDescriptor dataDescriptor : dataDescriptors) {
                boolean isAdded = false;
                String name = dataDescriptor.getName();
                for (Descriptor descriptor : descriptors) {
                    String descriptorName = descriptor.getName();
                    if (descriptorName.equals(name)) {
                        isAdded = true;
                    }
                }
                if (!isAdded) {
                    Descriptor descriptor = new Descriptor(name, 0);
                    descriptors.add(descriptor);
                }
            }
        }
    }

}
