package net.djtek.misc;

import java.util.ArrayDeque;

public class RPNCalculator {
    /**
     * Compute an RPN expression
     * @param expression The comma-delimited expression string
     * @return The computed value on success
     * @throws IllegalArgumentException On error
     */
    public static double compute(String expression) throws IllegalArgumentException {
        Double result = Double.NaN;

        // parse and add expression tokens to queue (FIFO)
        ArrayDeque<String> tokens = new ArrayDeque<>();
        for (String token : expression.split(",")){
            tokens.offerFirst(token);
        }

        // we always have one token (even for empty string)
        result = Double.parseDouble(tokens.pollLast());

        while (tokens.size() >= 2) {
            Double number = Double.parseDouble(tokens.pollLast());
            String operator = tokens.pollLast();

            if (operator.equals("+")) {
                result += number;
            } else if (operator.equals("-")) {
                result -= number;
            } else if (operator.equals("*")) {
                result *= number;
            } else if (operator.equals("/")) {
                result /= number;
            } else {
                throw new IllegalArgumentException("Unknown operator " + operator);
            }
        }

        return result;
    }
}