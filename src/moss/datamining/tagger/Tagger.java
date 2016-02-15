package moss.datamining.tagger;

import java.io.IOException;

/**
 * @author mossowsk
 * @since 6 lut 2016
 */
public class Tagger {
	
	private final static String TAGGER_PATH = "C:/tagger.py";

	public Tagger() {
		
	}

    /**
     * Executes python script
     * 
     * @param fileName
     */
	public void execute(String fileName) {
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("cmd /c python " + TAGGER_PATH + " " + fileName);
		} catch (IOException anException) {
			anException.printStackTrace();
		}
	}

}
