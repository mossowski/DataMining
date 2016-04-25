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
                ArrayList<Descriptor> descriptors = findByPattern(document.getElements(), pattern);
                document.getDescriptors().addAll(descriptors);
            }
            //System.out.println("Descriptor : " + document.getDescriptors().size());
        }
    }

    // --------------------------------------------------------------------------------

    /**
     * Finds descriptors by pattern
     * 
     * @param pattern
     * @return ArrayList<String>
     */
    public ArrayList<Descriptor> findByPattern(ArrayList<Element> document, ArrayList<String> pattern) {
        ArrayList<Descriptor> result = new ArrayList<Descriptor>();
        for (int i = 0; i < document.size(); i++) {
            int k = 0;
            StringBuilder match = new StringBuilder();
            for (int j = i; j < document.size(); j++) {
                String pos = document.get(j).getPartOfSpeech();
                String word = document.get(j).getWord();
                if (k < pattern.size() && pos.equals(pattern.get(k))) {
                    if (k == 0) {
                        match.append(word);
                    }
                    else {
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
                for (Descriptor desc : result) {
                    String descName = desc.getName();
                    if (descName.equals(name)) {
                        desc.increaseDocumentNumber();
                        isAdded = true;
                    }
                }
                if (!isAdded)
                    result.add(descriptor);
            }
        }
        return result;
    }

}
