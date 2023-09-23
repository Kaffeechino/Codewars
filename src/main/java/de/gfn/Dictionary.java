/**
 * Did you mean ...?
 * aka: Auto-complete
 * https://www.codewars.com/kata/5259510fc76e59579e0009d4/train/java
 *
 */

package de.gfn;

import java.util.Arrays;
import java.util.Comparator;

public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        Comparator<String> comparator = (s1, s2) -> (numToChange(s1, to) - numToChange(s2, to));
        Arrays.sort(words, comparator);

        return words[0];
    }

    public int numToChange(String dictWord, String typedWord) {
        /*
          Consider:|  heaven | is the order when similarity of these String is maximal.
                   |  _java_ |
          At this point the number of characters to change is length of a bigger String
          minus sameChars().
        */
        return Math.max(dictWord.length(), typedWord.length()) - sameChars(dictWord, typedWord);
    }

    public int sameChars(String dictWord, String typedWord) {
        String blanksNeededStr = " ".repeat(dictWord.length() - 1);
        String dictWordTemplate = blanksNeededStr + dictWord + blanksNeededStr;
        int sameChars = 0;
        int numLoops = dictWordTemplate.length() - typedWord.length();
        for (int i = 0; i < numLoops; i++) {
            /*
            In this for-loop the 2 strings are compared following this template/pattern:
                left-side                    ________dictWord_________      right-side
            0        --> i                   typedWord________________      dictWordTemplate.length()
            1        --> i                   _typedWord_______________
                                                     . . .
                                             ________________typedWord  0   dictWordTemplate.length() - i
                                             
                By doing so, we find out the maximum similarity of these 2 Strings.                             
            */
            String typedWordTemplate = " ".repeat(i) + typedWord + " ".repeat(numLoops - i);

            int similarity = 0;
            for (int j = 0; j < dictWordTemplate.length(); j++) {
                boolean equalityCondition = (dictWordTemplate.charAt(j) != ' ' &&
                        typedWordTemplate.charAt(j) != ' ') &&
                        (dictWordTemplate.charAt(j) == typedWordTemplate.charAt(j));
                similarity += equalityCondition ? 1 : 0;
            }
            sameChars = Math.max(sameChars, similarity);
        }
        return sameChars;
    }

    public static void main(String[] args) {
        // Demonstration:

    }
}