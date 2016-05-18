package moss.datamining.bon;

import java.util.ArrayList;
import java.util.HashMap;

import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;
import moss.datamining.model.Element;
import moss.datamining.utility.FileReader;

import static moss.datamining.bon.Data.*;
import static moss.datamining.utility.Settings.BON_DATA_PATH;;


public class Pattern {

    public static ArrayList<ArrayList<String>> listOfPatterns = FileReader.loadPatterns(BON_DATA_PATH + "pattern.txt");

    // --------------------------------------------------------------------------------

    /**
     * Finds all descriptors
     * 
     * @param data
     */
    public static void findDesciptors() {
        for (Document document : documents.values()) {
            for (ArrayList<String> pattern : listOfPatterns) {
                HashMap<String, Descriptor> descriptors = findByPattern(document, pattern);
                document.setDescriptors(descriptors);
            }
        }
    }

    // --------------------------------------------------------------------------------

    /**
     * Finds descriptors by pattern
     * 
     * @param pattern
     * @return ArrayList<String>
     */
    public static HashMap<String, Descriptor> findByPattern(Document document, ArrayList<String> pattern) {
        HashMap<String, Descriptor> descriptors = document.getDescriptors();
        ArrayList<Element> elements = document.getElements();
        for (int i = 0; i < elements.size(); i++) {
            int k = 0;
            StringBuilder match = new StringBuilder();
            for (int j = i; j < elements.size(); j++) {
                String pos = elements.get(j).getPartOfSpeech();
                String word = elements.get(j).getWord();
                if (k < pattern.size() && pos.equals(pattern.get(k))) {
                    if (k == 0) {
                        match.append(word);
                    } else {
                        match.append(" " + word);
                    }
                    k++;
                } else {
                    break;
                }
            }
            if (k == pattern.size()) {
                Descriptor descriptor = new Descriptor(match.toString(), 1);
                String name = descriptor.getName();
                if (descriptors.containsKey(name)) {
                    Descriptor desc = descriptors.get(name);
                    desc.increaseNumber();
                    document.increaseOccurrenceNumber();
                } else {
                    descriptors.put(name, descriptor);
                    document.increaseOccurrenceNumber();
                }
            }
        }
        return descriptors;
    }

}
