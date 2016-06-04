package com.moss.datamining.bon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import com.moss.datamining.model.Descriptor;
import com.moss.datamining.model.Document;
import com.moss.datamining.model.Element;
import com.moss.datamining.utility.FileReader;

import static com.moss.datamining.bon.Data.*;
import static com.moss.datamining.utility.Settings.*;


public class Pattern {

    public static ArrayList<ArrayList<String>> listOfPatterns = FileReader.loadPatterns(PATTERN_PATH);

    // --------------------------------------------------------------------------------

    /**
     * Finds all descriptors
     * 
     * @param data
     */
    public static void findDesciptors() {
        listOfPatterns = FileReader.loadPatterns(PATTERN_PATH);
        listOfPatterns.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> first, ArrayList<String> second) {
                return Integer.compare(second.size(), first.size());
            }
        });

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
            ArrayList<Integer> listOfUsedWords = new ArrayList<Integer>();
            StringBuilder match = new StringBuilder();
            int k = 0;
            for (int j = i; j < elements.size(); j++) {
                String pos = elements.get(j).getPartOfSpeech();
                String word = elements.get(j).getWord();
                boolean isUsed = elements.get(j).getIsUsed();
                if (k < pattern.size() && pos.equals(pattern.get(k)) && !isUsed) {
                    listOfUsedWords.add(j);
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
                // add descriptor
                Descriptor descriptor = new Descriptor(match.toString(), 1, pattern);
                String name = descriptor.getName();
                if (descriptors.containsKey(name)) {
                    Descriptor desc = descriptors.get(name);
                    desc.increaseNumber();
                    document.increaseOccurrenceNumber();
                } else {
                    descriptors.put(name, descriptor);
                    document.increaseOccurrenceNumber();
                }
                // mark used words
                for (Integer integer : listOfUsedWords) {
                    elements.get(integer).setIsUsed(true);
                }
            }
        }
        return descriptors;
    }

}
