package moss.datamining.tagger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static moss.datamining.utility.Settings.*;

/**
 * @author mossowsk
 * @since 6 lut 2016
 */
public class Tagger {

	public Tagger() {

	}

	// --------------------------------------------------------------------------------

	/**
	 * Executes Python script
	 * 
	 * @param fileName
	 */
	public void execute(String fileName) {
		Runtime r = Runtime.getRuntime();
		try {
			System.out.println("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName + "\n");
			r.exec("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName);
		} catch (IOException anException) {
			anException.printStackTrace();
		}
	}

	// --------------------------------------------------------------------------------

	public void tagData() {
		File folder = new File(DATA_PATH);
		File[] listOfFiles = folder.listFiles();
		int numberOfFiles = listOfFiles.length - 1;
		System.out.println("------------------TAGGING------------------");
		System.out.println("Number of files : " + numberOfFiles + "\n");
		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println("Name : " + file.getName());
				System.out.println("Path : " + file.getPath());
				execute(file.getName());
			}
		}
		int numberOfTaggedFiles = 0;
		while (numberOfFiles != numberOfTaggedFiles) {
			try {
				numberOfTaggedFiles = (int) Files.list(Paths.get(TAGGED_DATA_PATH)).count();
			} catch (IOException anException) {
				anException.printStackTrace();
			}
		}
		System.out.println("---------------END OF TAGGING---------------");
	}

}
