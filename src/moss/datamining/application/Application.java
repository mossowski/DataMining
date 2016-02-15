package moss.datamining.application;


import java.util.Scanner;

import moss.datamining.tagger.Tagger;
import moss.datamining.utility.Document;

/**
 * @author mossowsk
 * @since 6 lut 2016
 */
public class Application {

	public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Document document = new Document();

        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. Execute tagger");
            System.out.println("2. Print document");

            int choice = console.nextInt();

            switch(choice) {
                case 0:
                    console.close();
                    System.exit(0);
                    break;
                case 1:
                    Tagger tagger = new Tagger();
                    tagger.execute("eng.txt");
                    break;
                case 2:
                    document.printDocument();
                    break;
            }
        }
	}

}
