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
     * 
     * @param file
     * @return ArrayList<Element>
     */
    public ArrayList<Element> loadData(File file) {
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
                        Element element = new Element(word, partOfSpeech);
                        result.add(element);
                    }
                }
            }
        }
        catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
        return result;
    }

}
