package moss.datamining.tagger;

import java.io.IOException;

public class Tagger {
	
	private final static String TAGGER_PATH = "C:/tagger.py";

	public Tagger() {
		
	}
	
	public void execute(String fileName) {
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("cmd /c python " + TAGGER_PATH + " " + fileName);
		} catch (IOException anException) {
			anException.printStackTrace();
		}
	}

}
