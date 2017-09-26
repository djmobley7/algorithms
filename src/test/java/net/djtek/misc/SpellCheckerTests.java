package net.djtek.misc;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class SpellCheckerTests {
    @Test
    public void computeWordDistanceTests(){
        SpellChecker spellChecker = new SpellChecker();
        assertEquals(0, spellChecker.computeWordDistance("cat", "cat"));

        assertEquals(1, spellChecker.computeWordDistance("cat", "rat"));
        assertEquals(1, spellChecker.computeWordDistance("cat", "cut"));
        assertEquals(1, spellChecker.computeWordDistance("cat", "car"));
        assertEquals(1, spellChecker.computeWordDistance("rat", "cat"));
        assertEquals(1, spellChecker.computeWordDistance("cut", "cat"));
        assertEquals(1, spellChecker.computeWordDistance("car", "cat"));

        assertEquals(1, spellChecker.computeWordDistance("cat", "at"));
        assertEquals(2, spellChecker.computeWordDistance("cat", "a"));
        assertEquals(3, spellChecker.computeWordDistance("cat", ""));
        assertEquals(1, spellChecker.computeWordDistance("at", "cat"));
        assertEquals(2, spellChecker.computeWordDistance("a", "cat"));
        assertEquals(3, spellChecker.computeWordDistance("", "cat"));

        assertEquals(3, spellChecker.computeWordDistance("cat", "dog"));
        assertEquals(3, spellChecker.computeWordDistance("dog", "cat"));
    }
}
