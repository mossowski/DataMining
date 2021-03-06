package com.moss.datamining.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.moss.datamining.model.Element;

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
     * @param stopsigns
     * @return
     */
    public static ArrayList<Element> loadData(String pathName, String stopsignsPathName) {
        File file = new File(pathName);
        ArrayList<String> stopsigns = loadStopsigns(stopsignsPathName);
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
                        // dot at the end of sentence
                        if (word.equals(".")) {
                            Element element = new Element(" ", " ");
                            result.add(element);
                        } else if (!stopsigns.contains(word) && isValidWord(word)) {
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
     * Loads stopsigns
     * 
     * @param file
     * @return
     */
    public static ArrayList<String> loadStopsigns(String pathName) {
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

    // --------------------------------------------------------------------------------

    /**
     * Checks if word does not contain any invalid characters
     * 
     * @param word
     * @return
     */
    public static boolean isValidWord(String word) {
        String[] invalidCharacters = {",", "'", "_", "!", "?", "\\", "$", "^", "*", "(", ")"};
        for (int i = 0; i < invalidCharacters.length; i++) {
            String invalidCharacter = invalidCharacters[i];
            if (word.contains(invalidCharacter)) {
                return false;
            }
        }
        return true;
    }

}
