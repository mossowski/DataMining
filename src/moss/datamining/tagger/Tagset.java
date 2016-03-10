package moss.datamining.tagger;

/**
 * @author mossowsk
 * @since 7 lut 2016
 */
public class Tagset {

    public final static String coordinatingConjunction               = "CC";   // koniunkcja np. and, but, or, nor, for, yet, so
    public final static String cardinalNumber                        = "CD";   // liczebnik glowny np. one, two, three, four
    public final static String determiner                            = "DT";   // np. a, an, the, every, any, some, each, that, these, this
    public final static String existentialThere                      = "EX";   // np. there
    public final static String foreignWord                           = "FW";   // obce slowo
    public final static String prepositionOrSubordinatingConjunction = "IN";   // spojnik np. above, after, behind, at, into, like, of, upon, near
    public final static String adjective                             = "JJ";   // przymiotnik np. big, fat, red, sad
    public final static String adjectiveComparative                  = "JJR";  // np. bigger, fatter, redder, sadder
    public final static String adjectiveSuperlative                  = "JJS";  // np. biggest, fattest, reddest, saddest
    public final static String listItemMarker                        = "LS";   // np. 1., 2., a, a.,
    public final static String modal                                 = "MD";   // czasowniki modalne np. can, could, may, might, will, would, shall, should
    public final static String nounSingularOrMass                    = "NN";   // rzeczownik w lp. lub niepoliczalny np. boat, house, cat, blood, knowledge, music
    public final static String nounPlural                            = "NNS";  // rzeczownik w lm. np. boats, houses, cats
    public final static String properNounSingular                    = "NNP";  // w lp. np. Mr., Bell, Sarah, San Francisco
    public final static String properNounPlural                      = "NNPS"; // w lm. np. Oreos, Germans
    public final static String predeterminer                         = "PDT";  // np. both, a lof of, many, all, half
    public final static String possessiveEnding                      = "POS";  // np. 's, '
    public final static String personalPronoun                       = "PRP";  // zaimek osobowy np. I, me, you, he, him
    public final static String possessivePronoun                     = "PRP$"; // zaimek dzierzawczy np. my, your, his, her, its, our, their
    public final static String adverb                                = "RB";   // przyslowek np. quietly, carefully, happily
    public final static String adverbComparative                     = "RBR";  // np. more quietly, more carefully, more happily
    public final static String adverbSuperlative                     = "RBS";  // np. most quietly, most carefully, most happily
    public final static String particle                              = "RP";   // partykula np. along, away, back, by, forward, in, under
    public final static String symbol                                = "SYM";  // symbole matematyczne
    public final static String to                                    = "TO";   // np. to
    public final static String interjection                          = "UH";   // !!! np. ahh, oh, phew, shh, uh, wow, yeah
    public final static String verbBaseForm                          = "VB";   // czasownik po "to" albo modalnym np. do, learn, use, jump, study
    public final static String verbPastTense                         = "VBD";  // czasownik w czasie przeszlym np. were, said, visited
    public final static String verbGerundOrPresentParticiple         = "VBG";  // np. lying, dying, traveling, doing
    public final static String verbPastParticiple                    = "VBN";  // np. done, seen, gone, dived, bought, caught, blown
    public final static String verbNon3rdPersonSingularPresent       = "VBP";  // np. do, learn, use, jump, study
    public final static String verb3rdPersonSingularPresent          = "VBZ";  // np. speaks, plays, gives, makes
    public final static String whDeterminer                          = "WDT";  // np. wh-determiner np. which, when
    public final static String whPronoun                             = "WP";   // wh-word np. what, who, whom
    public final static String possessiveWhPronoun                   = "WP$";  // wh-word np. whose
    public final static String whAdverb                              = "WRB";  // np. how, where, why

}
