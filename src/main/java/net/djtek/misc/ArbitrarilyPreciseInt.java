package net.djtek.misc;

import java.util.ArrayList;
import java.util.List;

public class ArbitrarilyPreciseInt {
    // values are stored in reverse order e.g. 123456 is stored as 654321
    private List<Integer> values;

    /**
     * Create an arbitrarily precise, non-negative integer from a string.  The string
     * may contain underscores to improve readability for large values e.g. 1_000_000
     * @param str The string input
     */
    public ArbitrarilyPreciseInt(String str){
        if (str.length() == 0){
            throw new IllegalArgumentException("Not a number");
        }

        values = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);

            // skip underscores
            if (ch == '_') {
                continue;
            }

            // parse numeric value
            int value = Character.getNumericValue(ch);
            if (value >= 0){
                values.add(0, value);
            } else {
                throw new IllegalArgumentException(str + " is not a number");
            }
        }
    }

    /**
     * Increment by 1
     * @return The object
     */
    public ArbitrarilyPreciseInt increment(){
        return increment(1);
    }

    /**
     * Return primitive int value
     * @return int value
     * @throws NumberFormatException if too large
     */
    public int toInt(){
        return Integer.parseInt(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer value : values){
            sb.insert(0, value);
        }
        return sb.toString();
    }

    private ArbitrarilyPreciseInt increment(int amount){
        assert amount >= 0 && amount < 9 : "increment amount should be between 0 and 9";
        assert values.size() > 0 : "values size should be > 0";

        int index = 0;

        int digit = values.get(index) + amount;
        int carry = 0;
        if (digit >= 10){
            carry = digit / 10;
            digit %= 10;
        }
        values.set(index, digit);

        while (carry > 0){
            ++index;
            if (index > values.size() - 1){
                values.add(0);
            }

            digit = values.get(index) + carry;
            carry = 0;
            if (digit >= 10){
                carry = digit / 10;
                digit %= 10;
            }
            values.set(index, digit);
        }

        return this;
    }
}
