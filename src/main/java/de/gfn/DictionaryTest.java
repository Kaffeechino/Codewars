/**
 * Did you mean ...?
 * aka: Auto-complete
 * https://www.codewars.com/kata/5259510fc76e59579e0009d4/train/java
 *
 */
package de.gfn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {

    @Test
    public void testBerries() {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        assertEquals("strawberry", dictionary.findMostSimilar("strawbery"));
        assertEquals("cherry", dictionary.findMostSimilar("berry"));
    }

    @Test
    public void testLanguages() {
        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        assertEquals("java", dictionary.findMostSimilar("heaven"));
        assertEquals("javascript", dictionary.findMostSimilar("javascript"));
    }

}