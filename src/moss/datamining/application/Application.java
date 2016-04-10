package moss.datamining.application;

import java.util.ArrayList;
import java.util.Scanner;

import moss.datamining.partofspeech.PartOfSpeech;
import moss.datamining.tagger.Tagger;
import moss.datamining.utility.Document;
import moss.datamining.utility.FileReader;

import static moss.datamining.utility.Settings.*;

public class Application {

	public Application() {
		PartOfSpeech pos = new PartOfSpeech();
		FileReader fileReader = new FileReader();
		Tagger tagger = new Tagger();
		Document document = new Document();
		pos.setStopwords(fileReader.loadStopwords(STOPWORDS_PATH));
		Scanner console = new Scanner(System.in);

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
					document.setDocument(fileReader.loadData(ENG_PATH));
					break;
				case 4:
					document.setDocument(fileReader.loadData(DRACULA_PATH));
					break;
				case 5:
					document.printDocument();
					break;
				case 6:
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
