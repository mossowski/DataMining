package moss.datamining.model;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Element {

    private String word;
    private String partOfSpeech;

    // --------------------------------------------------------------------------------

    public Element(String word, String partOfSpeech) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }

    // --------------------------------------------------------------------------------

    public String getWord() {
        return word;
    }

    // --------------------------------------------------------------------------------

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

}
