package moss.datamining.tagger;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import moss.datamining.model.Document;
import static moss.datamining.utility.Settings.*;
import static moss.datamining.utility.FileReader.*;
import static moss.datamining.bon.Data.*;

/**
 * @author mossowsk
 * @since 6 lut 2016
 */
public class Tagger {

    // --------------------------------------------------------------------------------

    /**
     * Executes Python script
     * 
     * @param fileName
     */
    public static void execute(String fileName) {
        Runtime r = Runtime.getRuntime();
        try {
            System.out.println("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName + "\n");
            r.exec("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName);
        } catch (IOException anException) {
            anException.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------------

    public static void tagData() {
        File folder = new File(DATA_PATH);
        File[] listOfFiles = folder.listFiles();
        int numberOfFiles = listOfFiles.length - 3;
        System.out.println("------------------TAGGING------------------");
        System.out.println("Number of files : " + numberOfFiles + "\n");
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = file.getPath();
                System.out.println("Name : " + fileName);
                System.out.println("Path : " + filePath);
                execute(fileName);
            }
        }
        int numberOfTaggedFiles = 0;
        while (numberOfFiles != numberOfTaggedFiles) {
            try {
                numberOfTaggedFiles = (int) Files.list(Paths.get(TAGGED_DATA_PATH)).count();
            } catch (IOException anException) {
                anException.printStackTrace();
            }
        }
        System.out.println("---------------END OF TAGGING---------------");
    }

    // --------------------------------------------------------------------------------

    public static void getData() {
        File folder = new File(TAGGED_DATA_PATH);
        File[] listOfFiles = folder.listFiles();
        int numberOfFiles = listOfFiles.length;
        System.out.println("------------------LOADING------------------");
        System.out.println("Number of files : " + numberOfFiles + "\n");
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = file.getPath();
                System.out.println("Name : " + fileName);
                System.out.println("Path : " + filePath + "\n");
                Document document = new Document(loadData(filePath, STOPWORDS_PATH), fileName);
                documents.put(document.getName(), document);
            }
        }
        System.out.println("---------------END OF LOADING---------------");
    }

}
