package net.djtek.misc;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ArbitrarilyPreciseIntTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void incrementTests(){
        assertEquals(2, new ArbitrarilyPreciseInt("1").increment().toInt());

        // test carry over
        assertEquals(10, new ArbitrarilyPreciseInt("9").increment().toInt());
        assertEquals(1_000, new ArbitrarilyPreciseInt("999").increment().toInt());
        assertEquals(1_000_000_000, new ArbitrarilyPreciseInt("999_999_999").increment().toInt());

        // test carry over on really big integers
        assertEquals("1000000000000", new ArbitrarilyPreciseInt("999_999_999_999").increment().toString());
        assertEquals("1000000000000000000000", new ArbitrarilyPreciseInt("999_999_999_999_999_999_999").increment().toString());
    }

//    @Test
//    public void decrementTests(){
//        assertEquals(0, new ArbitrarilyPreciseInt("1").decrement().toInt());
//        assertEquals(9, new ArbitrarilyPreciseInt("10").decrement().toInt());
//        assertEquals(999_999_999, new ArbitrarilyPreciseInt("1_000_000_000").decrement().toInt());
//
//        thrown.expect(IllegalArgumentException.class);
//        assertEquals(0, new ArbitrarilyPreciseInt("0").decrement().toInt());
//    }

    @Test
    public void toIntTests(){
        thrown.expect(NumberFormatException.class);
        new ArbitrarilyPreciseInt("1_000_000_000_000_000_000").toInt();
    }

    @Test
    public void toStringTests(){
        assertEquals("1", new ArbitrarilyPreciseInt("1").toString());
        assertEquals("12", new ArbitrarilyPreciseInt("12").toString());
        assertEquals("123", new ArbitrarilyPreciseInt("123").toString());

        // zero tests
        assertEquals("0", new ArbitrarilyPreciseInt().toString());
        assertEquals("0", new ArbitrarilyPreciseInt("0").toString());

        // leading zero tests
        assertEquals("0", new ArbitrarilyPreciseInt("00").toString());
        assertEquals("1", new ArbitrarilyPreciseInt("01").toString());
        assertEquals("1", new ArbitrarilyPreciseInt("001").toString());
        assertEquals("123", new ArbitrarilyPreciseInt("0123").toString());
        assertEquals("123", new ArbitrarilyPreciseInt("00123").toString());
    }
}
