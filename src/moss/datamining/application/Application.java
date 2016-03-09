package moss.datamining.application;



import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.tagger.Tagger;
import moss.datamining.utility.Document;
import moss.datamining.utility.FileReader;

/**
 * @author mossowsk
 * @since 6 lut 2016
 */
public class Application {

	public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Tagger tagger = new Tagger();
        Document document = new Document();
        FileReader fileReader = new FileReader();

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
                    tagger.execute("eng.txt");
                    break;
                case 2:
                	File file = new File("C:/data/tag_eng.txt");
                	document.setDocument(fileReader.loadData(file));
                    document.printDocument();
                    break;
                case 3:
                	ArrayList<String> pattern = new ArrayList<String>();
                	pattern.add("NNS");
                	pattern.add("IN");
                	document.findByPattern(pattern);
                    break;
                default:
                    break;
            }
        }
	}

}
