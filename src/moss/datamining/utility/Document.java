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
	}

	// --------------------------------------------------------------------------------

	public Document(ArrayList<Element> document) {
		this.document = document;
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
	public void findByPattern(ArrayList<String> pattern) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < document.size(); i++) {
			int k = 0;
			String match = "";
			for (int j = i; j < document.size(); j++) {
				String pos = document.get(j).getPartOfSpeech();
				String word = document.get(j).getWord();
				if (k < pattern.size() && pos.equals(pattern.get(k))) {
					match += word + " ";
					k++;
				} else {
					break;
				}
			}
			if (k == pattern.size()) {
				result.add(match);
			}
		}
		result.forEach((e) -> System.out.println(e));
	}

	// --------------------------------------------------------------------------------

	/**
	 * Prints document
	 */
	public void printDocument() {
		document.forEach((e) -> System.out.println(e.getWord() + " " + e.getPartOfSpeech()));
	}

}
