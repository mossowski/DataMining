package moss.datamining.model;

import java.util.ArrayList;

public class Data {

	public ArrayList<Document> data;

	public Data() {
		data = new ArrayList<Document>();
	}

	// --------------------------------------------------------------------------------

	public void setData(ArrayList<Document> data) {
		this.data = data;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Prints data
	 */
	public void printData() {
		data.forEach((document) -> document.printDocument());
	}

}
