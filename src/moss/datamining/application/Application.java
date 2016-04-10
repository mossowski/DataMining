package moss.datamining.application;

import java.util.Scanner;

import moss.datamining.bon.Pattern;
import moss.datamining.model.Data;
import moss.datamining.tagger.Tagger;

public class Application {

	/**
	 * Runs application
	 */
	public static void run() {
		Tagger tagger = new Tagger();
		Data data = new Data();
		Pattern pattern = new Pattern();
		Scanner console = new Scanner(System.in);

		while (true) {
			System.out.println("0. Exit");
			System.out.println("1. Execute tagger");
			System.out.println("2. Load documents");
			System.out.println("3. Print data");
			System.out.println("4. Find by pattern");
			System.out.println("5. Print descriptors");

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
				data.setData(tagger.getData());
				break;
			case 3:
				data.printData();
				break;
			case 4:
				pattern.findDesciptors(data.data);
				break;
			case 5:
				data.data.get(0).printDescriptors();
				data.data.get(1).printDescriptors();
				break;
			default:
				break;
			}
		}
	}

}
