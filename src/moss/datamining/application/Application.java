package moss.datamining.application;

import java.util.Scanner;

import static moss.datamining.tagger.Tagger.*;
import static moss.datamining.utility.FileWriter.*;
import static moss.datamining.bon.BagOfNounPhrases.*;
import static moss.datamining.bon.Pattern.*;
import static moss.datamining.bon.Data.*;

public class Application {

    /**
     * Runs application
     */
    public static void run() {
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
                    getData();
                    break;
                case 3:
                    findDesciptors();
                    break;
                case 4:
                    findDataDesciptors();
                    saveDataDescriptors();
                    addDataDesciptors();
                    saveDescriptors();
                    break;
                default:
                    break;
            }
        }
    }

}
