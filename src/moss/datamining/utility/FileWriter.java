package moss.datamining.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import moss.datamining.bon.BagOfNounPhrases;
import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;
import moss.datamining.model.Element;

import static moss.datamining.bon.Data.*;
import static moss.datamining.utility.Settings.*;

public class FileWriter {

    // --------------------------------------------------------------------------------

    public static void saveDocuments() {
        for (Document document : documents.values()) {
            String fileName = document.getName();
            ArrayList<Element> elements = document.getElements();
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(DOCUMENTS_PATH + "doc_" + fileName))) {
                for (Element element : elements) {
                    StringBuilder line = new StringBuilder(element.getWord() + " " + element.getPartOfSpeech());
                    pw.println(line);
                }
            } catch (FileNotFoundException anException) {
                System.out.println("File not found!" + anException);
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static void saveDescriptors() {
        for (Document document : documents.values()) {
            String fileName = document.getName();
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            Map<String, Descriptor> treeMap = new TreeMap<String, Descriptor>(descriptors);
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(DESCRIPTORS_PATH + "desc_" + fileName))) {
                for (Descriptor descriptor : treeMap.values()) {
                    StringBuilder line = new StringBuilder(
                            descriptor.getName() + " " + descriptor.getNumber() + " " + descriptor.getWeight());
                    pw.println(line);
                }
            } catch (FileNotFoundException anException) {
                System.out.println("File not found!" + anException);
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static void saveSimilarPhrases() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(SIMILAR_PATH))) {
            ArrayList<String> similarPhrases = BagOfNounPhrases.findSimilarPhrases();
            for (String similarPhrase : similarPhrases) {
                StringBuilder line = new StringBuilder(similarPhrase);
                pw.println(line);
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
    }

    // --------------------------------------------------------------------------------

    public static void saveDataDescriptors() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(ALL_DESCRIPTORS_PATH))) {
            Map<String, DataDescriptor> treeMap = new TreeMap<String, DataDescriptor>(dataDescriptors);
            for (DataDescriptor dataDescriptor : treeMap.values()) {
                StringBuilder line = new StringBuilder(dataDescriptor.getName() + " " + dataDescriptor.getNumber() + " " + dataDescriptor.getDataNumber());
                pw.println(line);
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
    }

    // --------------------------------------------------------------------------------

    public static void saveBagOfNounPhrases() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(ARFF_PATH))) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            pw.println("% 1. Title: Bag of Noun Phrases");
            pw.println("%");
            pw.println("% 2. Sources:");
            pw.println("%      (a) Date: " + dateFormat.format(date));
            pw.println("%");
            pw.println("@RELATION bon\n");

            Map<String, DataDescriptor> dataDescriptorsTreeMap = new TreeMap<String, DataDescriptor>(dataDescriptors);
            for (DataDescriptor dataDescriptor : dataDescriptorsTreeMap.values()) {
                StringBuilder line = new StringBuilder("@ATTRIBUTE '" + dataDescriptor.getName() + "' NUMERIC");
                pw.println(line);
            }
            pw.println("\n@DATA");
            for (Document document : documents.values()) {
                Map<String, Descriptor> descriptorsTreeMap = new TreeMap<String, Descriptor>(document.getDescriptors());
                StringBuilder line = new StringBuilder();
                for (Descriptor descriptor : descriptorsTreeMap.values()) {
                    line.append(",");
                    line.append(descriptor.getWeight());
                }
                line.deleteCharAt(0);
                pw.println(line);
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
    }

    // --------------------------------------------------------------------------------

    public static void removeFiles() {
        // removes descriptors.txt file in bon directory
        File descriptorsFile = new File(ALL_DESCRIPTORS_PATH);
        descriptorsFile.delete();
        // removes bon.arff file in bon directory
        File arffFile = new File(ARFF_PATH);
        arffFile.delete();
        // removes similar.txt file in bon directory
        File similarFile = new File(SIMILAR_PATH);
        similarFile.delete();
        // removes all files in descriptors directory
        File descriptorsDirectory = new File(DESCRIPTORS_PATH);
        for (File file : descriptorsDirectory.listFiles())
            file.delete();
        // removes all files in documents directory
        File documentsDirectory = new File(DOCUMENTS_PATH);
        for (File file : documentsDirectory.listFiles())
            file.delete();
    }

}
