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

    @Test
    public void toIntTests(){
        thrown.expect(NumberFormatException.class);
        new ArbitrarilyPreciseInt("1_000_000_000_000_000_000").toInt();
    }

    @Test
    public void toStringTests(){
        ArbitrarilyPreciseInt i = new ArbitrarilyPreciseInt("123456");
        assertEquals("123456", i.toString());
    }
}
