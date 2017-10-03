package net.djtek.misc;

/**
 * Created by danmobley on 10/3/17.
 */
public class Palindrome {
    public static boolean isPalindrome(String word){
        boolean result = true;
        for (int start = 0, end = word.length() - 1; start < end; ++start, --end){
            if (Character.toUpperCase(word.charAt(start)) !=
                    Character.toUpperCase(word.charAt(end))){
                result = false;
                break;
            }
        }
        return result;
    }
}
