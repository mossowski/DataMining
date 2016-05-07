package moss.datamining.utility;

public class Settings {

    public final static String WORKING_PATH = System.getProperty("user.dir");
    public final static String TAGGER_PATH = WORKING_PATH + "\\python\\tagger.py";
    public final static String DATA_PATH = WORKING_PATH + "\\data\\";
    public final static String TAGGED_DATA_PATH = WORKING_PATH + "\\data\\tagged\\";
    public final static String BON_DATA_PATH = WORKING_PATH + "\\data\\bon\\";
    public final static String DESCRIPTORS_DATA_PATH = WORKING_PATH + "\\data\\descriptors\\";
    public final static String STOPWORDS_PATH = WORKING_PATH + "\\stopwords\\stopwords.txt";

}
