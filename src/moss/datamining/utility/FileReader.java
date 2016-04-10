package moss.datamining.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class FileReader {

	public FileReader() {

	}

	// --------------------------------------------------------------------------------

	/**
	 * Loads data from file
	 * @param pathName
	 * @param stopwords
	 * @return
	 */
	public ArrayList<Element> loadData(String pathName, ArrayList<String> stopwords) {
		File file = new File(pathName);
		ArrayList<Element> result = new ArrayList<>();
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				try (Scanner lineScanner = new Scanner(line)) {
					lineScanner.useDelimiter(" ");
					while (lineScanner.hasNext()) {
						// word partOfSpeech
						String word = lineScanner.next();
						String partOfSpeech = lineScanner.next();
						if (!stopwords.contains(word)) {
							Element element = new Element(word, partOfSpeech);
							result.add(element);
						}
					}
				}
			}
		} catch (FileNotFoundException anException) {
			System.out.println("File not found!" + anException);
		}
		return result;
	}

	// --------------------------------------------------------------------------------

	/**
	 * Loads stopwords
	 * 
	 * @param file
	 * @return
	 */
	public ArrayList<String> loadStopwords(String pathName) {
		File file = new File(pathName);
		ArrayList<String> result = new ArrayList<String>();
		try (Scanner s = new Scanner(file)) {
			while (s.hasNext()) {
				result.add(s.next());
			}
		} catch (FileNotFoundException anException) {
			System.out.println("File not found!" + anException);
		}
		return result;
	}

}
