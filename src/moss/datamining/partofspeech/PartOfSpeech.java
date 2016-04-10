package moss.datamining.partofspeech;

import java.util.ArrayList;

import moss.datamining.utility.Document;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class PartOfSpeech {

    public ArrayList<Document> data;
    public ArrayList<String> stopwords;

    public PartOfSpeech() {
    	data = new ArrayList<Document>();
    	stopwords = new ArrayList<String>();
    }

	public ArrayList<String> getStopwords() {
		return stopwords;
	}

	public void setStopwords(ArrayList<String> stopwords) {
		this.stopwords = stopwords;
	}

}
