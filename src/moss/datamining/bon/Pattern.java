package moss.datamining.bon;

import java.util.ArrayList;

import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;
import moss.datamining.model.Element;

public class Pattern {

    public ArrayList<ArrayList<String>> listOfPatterns;

    public Pattern() {
        listOfPatterns = new ArrayList<ArrayList<String>>();

        // TODO
        ArrayList<String> p1 = new ArrayList<String>();
        p1.add("JJ");
        p1.add("NN");

        ArrayList<String> p2 = new ArrayList<String>();
        p2.add("NN");
        p2.add("NN");

        listOfPatterns.add(p1);
        listOfPatterns.add(p2);
    }

    // --------------------------------------------------------------------------------

    /**
     * Finds all descriptors
     * 
     * @param data
     */
    public void findDesciptors(ArrayList<Document> documents) {
        for (Document document : documents) {
            for (ArrayList<String> pattern : listOfPatterns) {
                ArrayList<Descriptor> descriptors = findByPattern(document, pattern);
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
    public ArrayList<Descriptor> findByPattern(Document document, ArrayList<String> pattern) {
        ArrayList<Descriptor> descriptors = document.getDescriptors();
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
                boolean isAdded = false;
                Descriptor descriptor = new Descriptor(match.toString(), 1);
                String name = descriptor.getName();
                for (Descriptor desc : descriptors) {
                    String descName = desc.getName();
                    if (descName.equals(name)) {
                        desc.increaseNumber();
                        isAdded = true;
                    }
                }
                if (!isAdded)
                    descriptors.add(descriptor);
            }
        }
        return descriptors;
    }

}
