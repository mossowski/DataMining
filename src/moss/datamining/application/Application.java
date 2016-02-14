package moss.datamining.application;


import moss.datamining.tagger.Tagger;

public class Application {

	public static void main(String[] args) {
		System.out.println("---- Start POS tagger ----");
		Tagger tagger = new Tagger();
		System.out.println("eng.txt");
		tagger.execute("eng.txt");
		System.out.println("---- End POS tagger ----");
	}

}
