package net.djtek;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTests {
    @Test
    public void addTests(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals(0, tree.size());

        tree.add(50);
        assertEquals(1, tree.size());

        tree.add(25);
        assertEquals(2, tree.size());

        tree.add(100);
        assertEquals(3, tree.size());

        // duplicate
        tree.add(100);
        assertEquals(3, tree.size());

        tree.add(37);
        assertEquals(4, tree.size());
    }
}
