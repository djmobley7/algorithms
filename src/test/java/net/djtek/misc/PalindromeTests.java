package net.djtek.misc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by danmobley on 10/3/17.
 */
public class PalindromeTests {
    @Test
    public void isPalindromeTests(){
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("aa"));
        assertTrue(Palindrome.isPalindrome("aba"));
        assertTrue(Palindrome.isPalindrome("abA"));
        assertTrue(Palindrome.isPalindrome("abcdcba"));

        assertFalse(Palindrome.isPalindrome("ab"));
        assertFalse(Palindrome.isPalindrome("abc"));
        assertFalse(Palindrome.isPalindrome("abcdcbd"));
    }
}
