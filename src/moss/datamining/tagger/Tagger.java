package moss.datamining.tagger;

import java.io.IOException;

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
			System.out.println("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName);
			r.exec("cmd /c python " + TAGGER_PATH + " " + DATA_PATH + " " + fileName);
		} catch (IOException anException) {
			anException.printStackTrace();
		}
	}

}
