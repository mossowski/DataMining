package com.moss.datamining.bon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.moss.datamining.model.DataDescriptor;
import com.moss.datamining.model.Descriptor;
import com.moss.datamining.model.Document;

import static com.moss.datamining.bon.Data.*;
import static com.moss.datamining.utility.Settings.*;

public class BagOfNounPhrases {

    public static void findDataDesciptors() {
        for (Document document : documents.values()) {
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            for (Descriptor descriptor : descriptors.values()) {
                String descriptorName = descriptor.getName();
                int descriptorNumber = descriptor.getNumber();
                ArrayList<String> descriptorPattern = descriptor.getPattern();
                if (dataDescriptors.containsKey(descriptorName)) {
                    DataDescriptor dataDescriptor = dataDescriptors.get(descriptorName);
                    int number = descriptorNumber + dataDescriptor.getNumber();
                    dataDescriptor.setNumber(number);
                    dataDescriptor.increaseDataNumber();
                    dataDescriptor.getFiles().add(document.getName());
                } else {
                    DataDescriptor dataDescriptor = new DataDescriptor(descriptorName, descriptorNumber, descriptorPattern);
                    dataDescriptors.put(descriptorName, dataDescriptor);
                    dataDescriptor.getFiles().add(document.getName());
                }
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static ArrayList<String> findSimilarPhrases() {
        ArrayList<String> similarPhrases = new ArrayList<String>();
        ArrayList<DataDescriptor> descriptorsList = new ArrayList<DataDescriptor>();
        Map<String, DataDescriptor> treeMap = new TreeMap<String, DataDescriptor>(dataDescriptors);
        for (DataDescriptor dataDescriptor : treeMap.values()) {
            descriptorsList.add(dataDescriptor);
        }

        for (int i = 0; i < descriptorsList.size(); i++) {
            String currentDescriptor = descriptorsList.get(i).getName();
            for (int j = i + 1; j < descriptorsList.size(); j++) {
                String checkDescriptor = descriptorsList.get(j).getName();
                int similarity = levenshteinDistance(currentDescriptor, checkDescriptor);
                if (similarity > SIMILARITY) {
                    ArrayList<String> currentDescriptorFiles = descriptorsList.get(i).getFiles();
                    StringBuilder currentDescriptorFilesNames = new StringBuilder();
                    for (String fileName : currentDescriptorFiles) {
                        currentDescriptorFilesNames.append(fileName + " ");
                    }
                    ArrayList<String> descriptorFiles = descriptorsList.get(j).getFiles();
                    StringBuilder descriptorFilesNames = new StringBuilder();
                    for (String fileName : descriptorFiles) {
                        descriptorFilesNames.append(fileName + " ");
                    }
                    similarPhrases.add(currentDescriptor + " :: " + checkDescriptor + " ||| " + currentDescriptorFilesNames + " --- " + descriptorFilesNames);
                }
            }
        }
        return similarPhrases;
    }

    // --------------------------------------------------------------------------------

    public static void addDataDesciptors() {
        for (Document document : documents.values()) {
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            for (Entry<String, DataDescriptor> dataDescriptor : dataDescriptors.entrySet()) {
                String name = dataDescriptor.getKey();
                ArrayList<String> pattern = dataDescriptor.getValue().getPattern();
                if (!descriptors.containsKey(name)) {
                    Descriptor descriptor = new Descriptor(name, 0, pattern);
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
                    double weight = 1 / tf * idf;
                    weight = Math.round(weight * 100.0) / 100.0;
                    descriptor.setWeight(weight);
                }
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static int levenshteinDistance(String s, String t) {

        if (s.equals(t))
            return 100;

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

        double distance = v1[t.length()];
        double maximumLength = Math.max(s.length(), t.length());
        double percentageRatio = (1 - distance / maximumLength) * 100;
        int result = (int) Math.round(percentageRatio);
        return result;
    }

}
