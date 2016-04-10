package moss.datamining.utility;

public class Settings {

	public final static String WORKING_PATH = System.getProperty("user.dir");
	public final static String TAGGER_PATH = WORKING_PATH + "\\python\\tagger.py";
	public final static String DATA_PATH = WORKING_PATH + "\\data\\";
	public final static String STOPWORDS_PATH = WORKING_PATH + "\\stopwords\\stopwords.txt";
	
	//TEMP
	public final static String DRACULA_PATH = DATA_PATH + "tag_dracula.txt";
	public final static String ENG_PATH = DATA_PATH + "tag_eng.txt";
}
