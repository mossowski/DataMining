package moss.datamining.partofspeech;

import java.io.File;
import java.util.ArrayList;

import moss.datamining.utility.Document;
import moss.datamining.utility.FileReader;
import static moss.datamining.utility.Settings.*;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class PartOfSpeech {

	public ArrayList<Document> data;
	public ArrayList<String> stopwords;
	public FileReader fileReader;

	public PartOfSpeech() {
		data = new ArrayList<Document>();
		fileReader = new FileReader();
		stopwords = fileReader.loadStopwords(STOPWORDS_PATH);
	}

	// --------------------------------------------------------------------------------

	public void setData() {
		File folder = new File(TAGGED_DATA_PATH);
		File[] listOfFiles = folder.listFiles();
		int numberOfFiles = listOfFiles.length;
		System.out.println("------------------LOADING------------------");
		System.out.println("Number of files : " + numberOfFiles + "\n");
		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println("Name : " + file.getName());
				System.out.println("Path : " + file.getPath() + "\n");
				Document document = new Document(fileReader.loadData(file.getPath(), stopwords));
				data.add(document);
			}
		}
		System.out.println("---------------END OF LOADING---------------");
	}

	public ArrayList<String> getStopwords() {
		return stopwords;
	}

	public void setStopwords(ArrayList<String> stopwords) {
		this.stopwords = stopwords;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Prints data
	 */
	public void printData() {
		data.forEach((document) -> document.printDocument());
	}

}
