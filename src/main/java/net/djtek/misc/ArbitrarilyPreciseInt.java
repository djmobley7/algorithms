package net.djtek.misc;

import java.util.ArrayList;
import java.util.List;

public class ArbitrarilyPreciseInt {
    // values are stored in reverse order e.g. 123456 is stored as 654321
    private List<Integer> values;

    /**
     * Create a zero value arbitrarily precise, non-negative integer.
     */
    public ArbitrarilyPreciseInt(){
        this ("0");
    }

    /**
     * Create an arbitrarily precise, non-negative integer from a string.  The string
     * may contain underscores to improve readability for large values e.g. 1_000_000
     * @param str The string value
     */
    public ArbitrarilyPreciseInt(String str){
        if (str.length() == 0){
            new IllegalArgumentException("Not a number");
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
        return increment(1, 0);
    }

    public ArbitrarilyPreciseInt add(ArbitrarilyPreciseInt other){
        // TODO
        return this;
    }

//    /**
//     * Decrement by 1
//     * @return The object
//     */
//    public ArbitrarilyPreciseInt decrement() {
//        return decrement(1);
//    }

    /**
     * Return primitive int value
     * @return int value
     * @throws NumberFormatException if too large
     */
    public int toInt() throws NumberFormatException{
        return Integer.parseInt(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = indexOfMostSignificantDigit(); i >= 0; --i){
            sb.append(values.get(i));
        }

        // special case for all zeros
        if (sb.length() == 0){
            sb.append(0);
        }

        return sb.toString();
    }

    private ArbitrarilyPreciseInt increment(int amount, int startIndex){
        assert amount >= 0 && amount < 9 : "amount must be >= 0 && < 9";

        // add the required leading zeros
        addLeadingZeros(startIndex);

        int index = startIndex;

        int digit = values.get(index) + amount;
        int carry = 0;
        if (digit >= 10){
            carry = digit / 10;
            digit %= 10;
        }
        values.set(index, digit);

        while (carry > 0){
            ++index;
            if (index > indexOfLastDigit()){
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

//    private ArbitrarilyPreciseInt decrement(int amount){
//        assert amount >= 0 && amount < 9 : "increment amount should be between 0 and 9";
//        assert values.size() > 0 : "values size should be > 0";
//
//        int index = 0;
//
//        int digit = values.get(index) - amount;
//        int borrow = 0;
//        if (digit < 0){
//            // can we borrow?
//            if (index + 1 >= values.size()){
//                throw new IllegalArgumentException("Can not decrement below 0");
//            }
//            digit = 10 + digit;
//            borrow = 1;
//        }
//        values.set(index, digit);
//
//        while (borrow > 0){
//            ++index;
//
//            digit = values.get(index) - borrow;
//            borrow = 0;
//            if (digit < 0){
//                // can we borrow?
//                if (index + 1 >= values.size()){
//                    throw new IllegalArgumentException("Can not decrement below 0");
//                }
//                digit = 10 + digit;
//                borrow = 1;
//            }
//            values.set(index, digit);
//        }
//
//        return this;
//    }

    private void addLeadingZeros(int index){
        for (int i = indexOfLastDigit(); i < index; ++i){
            values.add(0);
        }
    }

    // includes leading zeros
    private int indexOfLastDigit(){
        return values.size() - 1;
    }

    // excludes leading zeros
    private int indexOfMostSignificantDigit(){
        int index = indexOfLastDigit();
        for  (; index >= 0 && values.get(index) == 0; --index);
        return index;
    }
}
