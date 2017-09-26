package net.djtek.data_structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTests {
    @Test
    public void addTests(){
        Heap<Integer> heap = new Heap<>();
        assertEquals(0, heap.size());

        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(2);
        heap.add(5);
        heap.add(6);
        heap.add(7);

        assertEquals(7, heap.size());

        // test max heap ordering
        assertEquals(7, heap.get(0).intValue());
        assertEquals(4, heap.get(1).intValue());
        assertEquals(6, heap.get(2).intValue());
        assertEquals(2, heap.get(3).intValue());
        assertEquals(3, heap.get(4).intValue());
        assertEquals(1, heap.get(5).intValue());
        assertEquals(5, heap.get(6).intValue());
    }

    @Test
    public void sortTests(){
        Heap<Integer> heap = new Heap<>();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(2);
        heap.add(5);
        heap.add(6);
        heap.add(7);

        heap.sort();

        // test sort ordering
        assertEquals(1, heap.get(0).intValue());
        assertEquals(2, heap.get(1).intValue());
        assertEquals(3, heap.get(2).intValue());
        assertEquals(4, heap.get(3).intValue());
        assertEquals(5, heap.get(4).intValue());
        assertEquals(6, heap.get(5).intValue());
        assertEquals(7, heap.get(6).intValue());
    }
}
