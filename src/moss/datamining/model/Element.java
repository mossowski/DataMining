package moss.datamining.model;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class Element {

    private String word;
    private String partOfSpeech;
    private boolean isUsed;

    // --------------------------------------------------------------------------------

    public Element(String word, String partOfSpeech) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.isUsed = false;
    }

    // --------------------------------------------------------------------------------

    public String getWord() {
        return word;
    }

    // --------------------------------------------------------------------------------

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    // --------------------------------------------------------------------------------

    public boolean getIsUsed() {
        return isUsed;
    }

    // --------------------------------------------------------------------------------

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

}
