package de.gfn;

public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        int index = 0;
        for (int i = 0; i < words.length; i++) {
        }
        return "string";
    }
    private int calcRequiredChanges(String word, String to) {
        int lettersToAdd, lettersToRemove, lettersToReplace;
        lettersToRemove = lettersToReplace = lettersToAdd = 0;
        int lenDiff = word.length() - to.length();
        lettersToAdd += Math.max(lenDiff, 0);
        for (int i = 0; i < to.length(); i++) {
            lettersToReplace += to.charAt(i) == word.charAt(i) ? 0 : 1;
        }
        return lettersToAdd + lettersToReplace;
    }
}
