package net.djtek.misc;

import org.junit.Test;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RPNCalculatorTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void computeTests() throws Exception {
        // single number
        assertEquals(1, RPNCalculator.compute("1"), 0);
        assertEquals(1, RPNCalculator.compute("1.0"), 0);
        assertEquals(-1, RPNCalculator.compute("-1"), 0);
        assertEquals(-1, RPNCalculator.compute("-1.0"), 0);

        // addition
        assertEquals(3, RPNCalculator.compute("1,2,+"), 0);

        // subtraction
        assertEquals(-1, RPNCalculator.compute("1,2,-"), 0);

        // multiplication
        assertEquals(2, RPNCalculator.compute("1,2,*"), 0);

        // division
        assertEquals(0.5, RPNCalculator.compute("1,2,/"), 0);

        // multiple operator tests
        assertEquals(1.5, RPNCalculator.compute("1,2,+,0.5,*"), 0);
        assertEquals(45, RPNCalculator.compute("100,10,/,5,+,3,*"), 0);

        // bad expression tests
        thrown.expect(IllegalArgumentException.class);
        RPNCalculator.compute("");
        RPNCalculator.compute("2,+,2");
        RPNCalculator.compute("1,2,3");
    }
}
