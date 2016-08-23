package com.moss.datamining.utility;

public class Settings {

    public final static String WORKING_PATH = System.getProperty("user.dir");
    public final static String TAGGER_PATH = WORKING_PATH + "\\python\\tagger.py";
    public final static String STOPWORDS_PATH = WORKING_PATH + "\\stopwords\\stopwords.txt";
    public final static String DATA_PATH = WORKING_PATH + "\\data\\";
    public final static String TAGGED_PATH = DATA_PATH + "tagged\\";
    public final static String DESCRIPTORS_PATH = DATA_PATH + "descriptors\\";
    public final static String DOCUMENTS_PATH = DATA_PATH + "documents\\";
    public final static String ARFF_PATH = DATA_PATH + "arff\\";
    public final static String PATTERN_PATH = ARFF_PATH + "pattern.txt";
    public final static String SIMILAR_PATH = ARFF_PATH + "similar.txt";
    public final static String ALL_DESCRIPTORS_PATH = ARFF_PATH + "descriptors.txt";
    public final static String ALL_DESCRIPTORS_FINAL_PATH = ARFF_PATH + "descriptorsFinal.txt";
    public final static String ARFF_BON_PATH = ARFF_PATH + "bon.arff";
    public final static String ARFF_DATA_PATH = ARFF_PATH + "data.arff";

    // application variables
    public final static int SIMILARITY = 70;

    public enum RequiredPartOfSpeech {
        NN, NNS, NNP, NNPS
    }

}
