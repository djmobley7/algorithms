package net.djtek.misc;

public class WordDistance {
    /**
     * Compute the word distance using Levenshtein distance algorithm
     * @param word1 First word to compare
     * @param word2 Second word to compare
     * @return The word distance, where 0 means the words match
     */
    public static int compute(String word1, String word2) {
        return compute(word1.toCharArray(), word2.toCharArray());
    }

    private static int compute(char[] word1, char[] word2){
        return compute(word1, word1.length, word2, word2.length);
    }

    private static int compute(char[] word1, int wordLength1, char[] word2, int wordLength2){
        if (wordLength1 == 0){
            return wordLength2;
        }
        if (wordLength2 == 0){
            return wordLength1;
        }

        int cost = 0;
        if (Character.toLowerCase(word1[wordLength1 - 1]) !=
                Character.toLowerCase(word2[wordLength2 - 1])){
            cost = 1;
        }

        return minimum(
                compute(word1, wordLength1 - 1, word2, wordLength2) + 1,
                compute(word1, wordLength1, word2, wordLength2 - 1) + 1,
                compute(word1, wordLength1 - 1, word2, wordLength2 - 1) + cost);
    }

    private static int minimum (int a, int b, int c){
        int result = a;
        if (b < result){
            result = b;
        }
        if (c < result){
            result = c;
        }
        return result;
    }
}
