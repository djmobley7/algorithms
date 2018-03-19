package net.djtek.data_structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTests {
    @Test
    public void emptyListTest(){
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.length());
        assertEquals("", list.toString());
    }

    @Test
    public void addToFrontTests(){
        LinkedList<Integer> list = new LinkedList<>();

        list.addToFront(3);
        assertEquals(1, list.length());
        assertEquals("3", list.toString());

        list.addToFront(2);
        assertEquals(2, list.length());
        assertEquals("2, 3", list.toString());

        list.addToFront(1);
        assertEquals(3, list.length());
        assertEquals("1, 2, 3", list.toString());
    }

    @Test
    public void addToTailTests(){
        LinkedList<Integer> list = new LinkedList<>();

        list.addToTail(1);
        assertEquals(1, list.length());
        assertEquals("1", list.toString());

        list.addToTail(2);
        assertEquals(2, list.length());
        assertEquals("1, 2", list.toString());

        list.addToTail(3);
        assertEquals(3, list.length());
        assertEquals("1, 2, 3", list.toString());
    }

    @Test
    public void addToFrontAndTailTests(){
        LinkedList<Integer> list = new LinkedList<>();

        list.addToFront(2);
        assertEquals(1, list.length());
        assertEquals("2", list.toString());

        list.addToTail(3);
        assertEquals(2, list.length());
        assertEquals("2, 3", list.toString());

        list.addToFront(1);
        assertEquals(3, list.length());
        assertEquals("1, 2, 3", list.toString());
    }

    @Test
    public void removeFromFrontTests(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        assertEquals(3, list.length());
        assertEquals("1, 2, 3", list.toString());

        assertEquals(1, (int)list.removeFromFront());
        assertEquals(2, list.length());
        assertEquals("2, 3", list.toString());

        assertEquals(2, (int)list.removeFromFront());
        assertEquals(1, list.length());
        assertEquals("3", list.toString());

        assertEquals(3, (int)list.removeFromFront());
        assertEquals(0, list.length());
        assertEquals("", list.toString());
    }

    @Test
    public void removeFromTailTests(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        assertEquals(3, list.length());
        assertEquals("1, 2, 3", list.toString());

        assertEquals(3, (int)list.removeFromTail());
        assertEquals(2, list.length());
        assertEquals("1, 2", list.toString());

        assertEquals(2, (int)list.removeFromTail());
        assertEquals(1, list.length());
        assertEquals("1", list.toString());

        assertEquals(1, (int)list.removeFromTail());
        assertEquals(0, list.length());
        assertEquals("", list.toString());
    }

    @Test
    public void removeFromFrontAndTailTests(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);

        assertEquals(1, (int)list.removeFromFront());
        assertEquals(2, list.length());
        assertEquals("2, 3", list.toString());

        assertEquals(3, (int)list.removeFromTail());
        assertEquals(1, list.length());
        assertEquals("2", list.toString());

        assertEquals(2, (int)list.removeFromFront());
        assertEquals(0, list.length());
        assertEquals("", list.toString());
    }
}