package moss.datamining.bon;

import java.util.ArrayList;

import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;
import moss.datamining.model.Element;

public class Pattern {
	
	public ArrayList<ArrayList<String>>  listOfPatterns; 

	public Pattern() {
		listOfPatterns = new ArrayList<ArrayList<String>>();
		
		//TODO
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
	 * @param data
	 */
	public void findDesciptors(ArrayList<Document> data) {
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < listOfPatterns.size(); j++) {
				data.get(i).descriptors.addAll(findByPattern(data.get(i).document, listOfPatterns.get(j)));
			}
		}
	}

	// --------------------------------------------------------------------------------

	/**
	 * Finds descriptors by pattern
	 * @param pattern
	 * @return ArrayList<String>
	 */
	public ArrayList<Descriptor> findByPattern(ArrayList<Element> document, ArrayList<String> pattern) {
		ArrayList<Descriptor> result = new ArrayList<Descriptor>();
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
				Descriptor descriptor = new Descriptor(match);
				result.add(descriptor);
			}
		}
		return result;
	}

}