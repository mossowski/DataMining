package moss.datamining.utility;

public class Settings {

    public final static String WORKING_PATH = System.getProperty("user.dir");
    public final static String TAGGER_PATH = WORKING_PATH + "\\python\\tagger.py";
    public final static String STOPWORDS_PATH = WORKING_PATH + "\\stopwords\\stopwords.txt";
    public final static String DATA_PATH = WORKING_PATH + "\\data\\";
    public final static String TAGGED_PATH = DATA_PATH + "tagged\\";
    public final static String BON_PATH = DATA_PATH + "bon\\";
    public final static String DESCRIPTORS_PATH = DATA_PATH + "descriptors\\";
    public final static String DOCUMENTS_PATH = DATA_PATH + "documents\\";

}
