package net.djtek.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danmobley on 10/3/17.
 */
public class PhoneMnemonics {
    private static final char[][] DIGIT_TO_LETTERS = {
            {'0'},
            {'1'},
            {'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z'}};

    public static List<String> find(String number){
        List<String> mnemonics = new ArrayList<>();
        findHelper(number, 0, "",  mnemonics);
        return mnemonics;
    }

    private static void findHelper(String number, int digit, String partialMnemonic, List<String> mnemonics){
        if (digit == number.length()){
            mnemonics.add(partialMnemonic);
        } else {
            char[] letters = DIGIT_TO_LETTERS[number.charAt(digit) - '0'];
            for (int i = 0; i < letters.length; ++i){
                findHelper(number, digit + 1, partialMnemonic + letters[i], mnemonics);
            }
        }
    }
}
