package moss.datamining.application;

import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.model.Data;
import moss.datamining.model.Document;

import static moss.datamining.tagger.Tagger.*;
import static moss.datamining.utility.FileWriter.*;
import static moss.datamining.bon.BagOfNounPhrases.*;
import static moss.datamining.bon.Pattern.*;

public class Application {

    /**
     * Runs application
     */
    public static void run() {
        Data data = new Data();
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. Execute tagger");
            System.out.println("2. Load documents");
            System.out.println("3. Find by pattern");
            System.out.println("4. Find all descriptors");

            int choice = console.nextInt();

            switch (choice) {
                case 0:
                    console.close();
                    System.exit(0);
                    break;
                case 1:
                    tagData();
                    break;
                case 2:
                    data.setDocuments(getData());
                    break;
                case 3:
                    ArrayList<Document> documents = data.getDocuments();
                    findDesciptors(documents);
                    // fileWriter.saveDescriptors(documents);
                    break;
                case 4:
                    documents = data.getDocuments();
                    findDataDesciptors(documents);
                    saveDescriptors();
                    addDataDesciptors(documents);
                    saveDescriptors(documents);
                    break;
                default:
                    break;
            }
        }
    }

}
