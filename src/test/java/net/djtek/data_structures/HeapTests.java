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

        // adding the above we should end up with a (max) heap of 7 4 6 2 3 1 5
        heap.print();
    }
}
