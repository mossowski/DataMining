package moss.datamining.utility;

import java.util.ArrayList;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Document {

    public ArrayList<Element> document;

    // --------------------------------------------------------------------------------

    public Document() {
        document = new ArrayList<>();
        // TODO
        Element e1 = new Element("house", "NN");
        Element e2 = new Element("smart", "JJ");
        Element e3 = new Element("dog", "NN");
        Element e4 = new Element("lazy", "JJ");
        Element e5 = new Element("cat", "NN");
        document.add(e1);
        document.add(e2);
        document.add(e3);
        document.add(e4);
        document.add(e5);
    }

    // --------------------------------------------------------------------------------

    public ArrayList<Element> getDocument() {
        return document;
    }

    // --------------------------------------------------------------------------------

    public void setDocument(ArrayList<Element> document) {
        this.document = document;
    }

    // --------------------------------------------------------------------------------

    /**
     * @param pattern
     * @return ArrayList<String>
     */
    public ArrayList<String> findByPattern(ArrayList<String> pattern) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < document.size(); i++) {
            int k = 0;
            String match = "";
            for (int j = i; j < document.size(); j++) {
                String pos = document.get(j).getPartOfSpeech();
                String word = document.get(j).getWord();
                if (pos.equals(pattern.get(k))) {
                    match += word;
                    k++;
                }
                else {
                    break;
                }
            }
            if (k == pattern.size()) {
                result.add(match);
            }
        }
        return result;
    }

    // --------------------------------------------------------------------------------

    /**
     * Prints document
     */
    public void printDocument() {
        document.forEach((e) -> System.out.println("word: " + e.getWord() + " pos:" + e.getPartOfSpeech()));
    }

}
