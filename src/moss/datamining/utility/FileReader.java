package moss.datamining.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.model.Element;

/**
 * @author mossowsk
 * @since 15 lut 2016
 */
public class FileReader {

    // --------------------------------------------------------------------------------

    /**
     * Loads data from file
     * 
     * @param pathName
     * @param stopwords
     * @return
     */
    public static ArrayList<Element> loadData(String pathName, String stopwordsPathName) {
        File file = new File(pathName);
        ArrayList<String> stopwords = loadStopwords(stopwordsPathName);
        ArrayList<Element> result = new ArrayList<Element>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                try (Scanner lineScanner = new Scanner(line)) {
                    lineScanner.useDelimiter(" ");
                    while (lineScanner.hasNext()) {
                        // word partOfSpeech
                        String word = lineScanner.next().toUpperCase();
                        word = word.trim().replaceAll("\\s+", " ");
                        String partOfSpeech = lineScanner.next();
                        if (!stopwords.contains(word) && !word.contains("'") && !word.contains("_") && !word.contains("-")) {
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
    public static ArrayList<String> loadStopwords(String pathName) {
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

    // --------------------------------------------------------------------------------

    /**
     * Loads patterns from file
     * 
     * @param pathName
     * @return
     */
    public static ArrayList<ArrayList<String>> loadPatterns(String pathName) {
        File file = new File(pathName);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                try (Scanner lineScanner = new Scanner(line)) {
                    lineScanner.useDelimiter(" ");
                    ArrayList<String> pattern = new ArrayList<String>();
                    while (lineScanner.hasNext()) {
                        String element = lineScanner.next();
                        pattern.add(element);
                    }
                    result.add(pattern);
                }
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
        return result;
    }

}
