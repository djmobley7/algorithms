package net.djtek.misc;

import java.util.ArrayList;
import java.util.List;

public class ArbitrarilyPreciseInt {
    private List<Integer> values;

    /**
     * Create an arbitrarily precise, non-negative integer from a string
     * @param str The string input
     */
    public ArbitrarilyPreciseInt(String str){
        if (str.length() == 0){
            throw new IllegalArgumentException("Not a number");
        }

        values = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i){
            int value = Character.getNumericValue(str.charAt(i));
            if (value >= 0){
                values.add(value);
            } else {
                throw new IllegalArgumentException(str + " is not a number");
            }
        }
    }

    /**
     * Increment by 1
     */
    public void increment(){
        // TODO
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer value : values){
            sb.append(value);
        }
        return sb.toString();
    }
}
