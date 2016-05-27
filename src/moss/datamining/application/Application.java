package moss.datamining.application;

import java.util.Scanner;

import static moss.datamining.tagger.Tagger.*;
import static moss.datamining.utility.FileWriter.*;
import static moss.datamining.bon.BagOfNounPhrases.*;
import static moss.datamining.bon.Data.*;
import static moss.datamining.bon.Pattern.*;

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
                    long startTime = System.currentTimeMillis();
                    long previousTime = System.currentTimeMillis();
                    long currentTime;
                    cleanData();
                    currentTime = System.currentTimeMillis();
                    System.out.println("cleanData            :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    removeFiles();
                    currentTime = System.currentTimeMillis();
                    System.out.println("removeFiles          :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    getData();
                    currentTime = System.currentTimeMillis();
                    System.out.println("getData              :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    saveDocuments();
                    currentTime = System.currentTimeMillis();
                    System.out.println("saveDocuments        :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    findDesciptors();
                    currentTime = System.currentTimeMillis();
                    System.out.println("findDesciptors       :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    findDataDesciptors();
                    currentTime = System.currentTimeMillis();
                    System.out.println("findDataDesciptors   :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    saveDataDescriptors();
                    currentTime = System.currentTimeMillis();
                    System.out.println("saveDataDescriptors  :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    addDataDesciptors();
                    currentTime = System.currentTimeMillis();
                    System.out.println("addDataDesciptors    :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    saveSimilarPhrases();
                    currentTime = System.currentTimeMillis();
                    System.out.println("saveSimilarPhrases   :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    countWeight();
                    currentTime = System.currentTimeMillis();
                    System.out.println("countWeight          :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    saveDescriptors();
                    currentTime = System.currentTimeMillis();
                    System.out.println("saveDescriptors      :" + (currentTime - previousTime));
                    previousTime = currentTime;
                    saveBagOfNounPhrases();
                    currentTime = System.currentTimeMillis();
                    System.out.println("saveBagOfNounPhrases :" + (currentTime - previousTime));
                    long endTime = System.currentTimeMillis();
                    System.out.println("All                  :" + (endTime - startTime));
                    break;
                default:
                    break;
            }
        }
    }

}
