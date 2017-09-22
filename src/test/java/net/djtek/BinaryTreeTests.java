package net.djtek;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTests {
    @Test
    public void addTests(){
        // empty tree
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

    @Test
    public void containsTests() {
        // empty tree
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertEquals(false, tree.contains(50));

        tree.add(50);
        assertEquals(true, tree.contains(50));
        assertEquals(false, tree.contains(100));

        // left/right nodes off of root
        tree.add(25);
        tree.add(100);
        assertEquals(true, tree.contains(50));
        assertEquals(true, tree.contains(25));
        assertEquals(true, tree.contains(100));
        assertEquals(false, tree.contains(0));
        assertEquals(false, tree.contains(37));
        assertEquals(false, tree.contains(75));

        // add more levels of nodes
        tree.add(37);
        tree.add(31);
        tree.add(42);
        tree.add(46);
        assertEquals(true, tree.contains(37));
        assertEquals(true, tree.contains(31));
        assertEquals(true, tree.contains(42));
        assertEquals(true, tree.contains(46));
        assertEquals(false, tree.contains(48));
    }
}
