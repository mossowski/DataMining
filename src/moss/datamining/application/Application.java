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
			System.out.println("1. Execute tagger eng");
			System.out.println("2. Execute tagger dracula");
			System.out.println("3. Load document eng");
			System.out.println("4. Load document dracula");
			System.out.println("5. Print document");
			System.out.println("6. Find by pattern");

			int choice = console.nextInt();

			switch (choice) {
				case 0:
					console.close();
					System.exit(0);
					break;
				case 1:
					tagger.execute("eng.txt");
					break;
				case 2:
					tagger.execute("dracula.txt");
					break;
				case 3:
					File fileEng = new File("C:/data/tag_eng.txt");
					document.setDocument(fileReader.loadData(fileEng));
					break;
				case 4:
					File fileDracula = new File("C:/data/tag_dracula.txt");
					document.setDocument(fileReader.loadData(fileDracula));
					break;
				case 5:
					document.printDocument();
					break;
				case 6:
					ArrayList<String> pattern = new ArrayList<String>();
					pattern.add("JJ");
					pattern.add("NN");
					//pattern.add("IN");
					//pattern.add("JJ");
					document.findByPattern(pattern);
					break;
				default:
					break;
			}
		}
	}

}
