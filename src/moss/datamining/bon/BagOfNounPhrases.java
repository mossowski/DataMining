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
                if (dataDescriptors.containsKey(descriptorName)) {
                    DataDescriptor dataDescriptor = dataDescriptors.get(descriptorName);
                    int number = descriptorNumber + dataDescriptor.getNumber();
                    dataDescriptor.setNumber(number);
                    dataDescriptor.increaseDataNumber();
                } else {
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

    // --------------------------------------------------------------------------------

    public static void countWeight() {
        for (Document document : documents.values()) {
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            for (Descriptor descriptor : descriptors.values()) {
                int number = descriptor.getNumber();
                if (number > 0) {
                    // descriptor frequency
                    double tf = (double) number / (double) document.getOccurrenceNumber();
                    // number of documents
                    double N = documents.size();
                    // number of documents containing descriptor
                    double df = dataDescriptors.get(descriptor.getName()).getDataNumber();
                    // descriptor reverse frequency
                    double idf = Math.log(N / df) / Math.log(10);
                    descriptor.setWeight(1 / tf * idf);
                }
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static int levenshteinDistance(String s, String t, boolean lowerCase) {

        if (lowerCase) {
            s = s.toLowerCase();
            t = t.toLowerCase();
        }

        if (s.equals(t))
            return 0;

        // create two work vectors of integer distances
        int[] v0 = new int[t.length() + 1];
        int[] v1 = new int[t.length() + 1];

        // initialize v0 (the previous row of distances)
        // this row is A[0][i]: edit distance for an empty s
        // the distance is just the number of characters to delete from t
        for (int i = 0; i < v0.length; i++)
            v0[i] = i;

        for (int i = 0; i < s.length(); i++) {
            // calculate v1 (current row distances) from the previous row v0

            // first element of v1 is A[i+1][0]
            // edit distance is delete (i+1) chars from s to match empty t
            v1[0] = i + 1;

            // use formula to fill in the rest of the row
            for (int j = 0; j < t.length(); j++) {
                int cost = (s.charAt(i) == t.charAt(j)) ? 0 : 1;
                v1[j + 1] = Math.min(Math.min(v1[j] + 1, v0[j + 1] + 1), v0[j] + cost);
            }

            // copy v1 (current row) to v0 (previous row) for next iteration
            for (int j = 0; j < v0.length; j++)
                v0[j] = v1[j];
        }

        return v1[t.length()];
    }

}
