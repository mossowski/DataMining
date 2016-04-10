package moss.datamining.application;

import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.partofspeech.PartOfSpeech;
import moss.datamining.tagger.Tagger;
import moss.datamining.utility.Document;

public class Application {

	public Application() {
		PartOfSpeech pos = new PartOfSpeech();
		Tagger tagger = new Tagger();
		Document document = new Document();
		Scanner console = new Scanner(System.in);

		while (true) {
			System.out.println("0. Exit");
			System.out.println("1. Execute tagger");
			System.out.println("2. Load documents");
			System.out.println("3. Print data");
			System.out.println("4. Find by pattern");

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
				pos.setData();
				break;
			case 3:
				pos.printData();
				break;
			case 4:
				ArrayList<String> pattern = new ArrayList<String>();
				pattern.add("JJ");
				pattern.add("NN");
				document.findByPattern(pattern);
				break;
			default:
				break;
			}
		}
	}

}
