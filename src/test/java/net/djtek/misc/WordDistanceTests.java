package net.djtek.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordDistanceTests {
    @Test
    public void computeTests(){
        WordDistance spellChecker = new WordDistance();
        assertEquals(0, spellChecker.compute("cat", "cat"));
        assertEquals(0, spellChecker.compute("CAT", "cat"));
        assertEquals(0, spellChecker.compute("cAt", "CaT"));

        assertEquals(1, spellChecker.compute("cat", "rat"));
        assertEquals(1, spellChecker.compute("cat", "cut"));
        assertEquals(1, spellChecker.compute("cat", "car"));
        assertEquals(1, spellChecker.compute("rat", "cat"));
        assertEquals(1, spellChecker.compute("cut", "cat"));
        assertEquals(1, spellChecker.compute("car", "cat"));

        assertEquals(1, spellChecker.compute("cat", "at"));
        assertEquals(2, spellChecker.compute("cat", "a"));
        assertEquals(3, spellChecker.compute("cat", ""));
        assertEquals(1, spellChecker.compute("at", "cat"));
        assertEquals(2, spellChecker.compute("a", "cat"));
        assertEquals(3, spellChecker.compute("", "cat"));

        assertEquals(3, spellChecker.compute("cat", "dog"));
        assertEquals(3, spellChecker.compute("dog", "cat"));
    }
}
