package com.moss.datamining.utility;

public class Settings {

    public final static String WORKING_PATH = System.getProperty("user.dir");
    public final static String TAGGER_PATH = WORKING_PATH + "\\python\\tagger.py";
    public final static String STOPWORDS_PATH = WORKING_PATH + "\\stopwords\\stopwords.txt";
    public final static String DATA_PATH = WORKING_PATH + "\\data\\";
    public final static String TAGGED_PATH = DATA_PATH + "tagged\\";
    public final static String DESCRIPTORS_PATH = DATA_PATH + "descriptors\\";
    public final static String DOCUMENTS_PATH = DATA_PATH + "documents\\";
    public final static String BOW_PATH = DATA_PATH + "bow\\";
    public final static String BON_PATH = DATA_PATH + "bon\\";
    public final static String PATTERN_PATH = BON_PATH + "pattern.txt";
    public final static String SIMILAR_PATH = BON_PATH + "similar.txt";
    public final static String ALL_DESCRIPTORS_PATH = BON_PATH + "descriptors.txt";
    public final static String ALL_DESCRIPTORS_FINAL_PATH = BON_PATH + "descriptorsFinal.txt";
    public final static String ARFF_BON_PATH = BON_PATH + "bon.arff";
    public final static String ARFF_BOW_PATH = BOW_PATH + "bow.arff";

    // application variables
    public final static int SIMILARITY = 70;

}
