package moss.datamining.application;

import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.bon.BagOfNounPhrases;
import moss.datamining.bon.Pattern;
import moss.datamining.model.Data;
import moss.datamining.model.Document;
import moss.datamining.tagger.Tagger;
import moss.datamining.utility.FileWriter;

public class Application {

    /**
     * Runs application
     */
    public static void run() {
        Tagger tagger = new Tagger();
        Data data = new Data();
        Pattern pattern = new Pattern();
        BagOfNounPhrases bon = new BagOfNounPhrases();
        FileWriter fileWriter = new FileWriter();
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
                    tagger.tagData();
                    break;
                case 2:
                    data.setDocuments(tagger.getData());
                    break;
                case 3:
                    ArrayList<Document> documents = data.getDocuments();
                    pattern.findDesciptors(documents);
                    // fileWriter.saveDescriptors(documents);
                    break;
                case 4:
                    documents = data.getDocuments();
                    bon.findDataDesciptors(documents);
                    fileWriter.saveDescriptors();
                    bon.addDataDesciptors(documents);
                    fileWriter.saveDescriptors(documents);
                    break;
                default:
                    break;
            }
        }
    }

}
