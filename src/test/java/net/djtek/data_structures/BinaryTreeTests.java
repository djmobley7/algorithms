package net.djtek.data_structures;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        tree.add(75);
        assertEquals(3, tree.size());

        // duplicate
        tree.add(75);
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
        tree.add(75);
        assertEquals(true, tree.contains(50));
        assertEquals(true, tree.contains(25));
        assertEquals(true, tree.contains(75));
        assertEquals(false, tree.contains(0));
        assertEquals(false, tree.contains(37));

        // add more levels of nodes
        tree.add(0);
        tree.add(37);
        tree.add(67);
        tree.add(87);
        assertEquals(true, tree.contains(0));
        assertEquals(true, tree.contains(37));
        assertEquals(true, tree.contains(67));
        assertEquals(true, tree.contains(87));
    }

    @Test
    public void printTests(){
        // Construct a binary tree as follows:
        //              50
        //         |----------|
        //        25         75
        //     |------|    |------|
        //    12     37   67     87

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(12);
        tree.add(37);
        tree.add(67);
        tree.add(87);

        // redirect stdout to ByteArrayOutputStream for junit
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream oldPrintStream = System.out;
        System.setOut(printStream);

        // inorder should print 12 25 37 50 67 75 87
        tree.print();
        printStream.flush();
        assertEquals("12 25 37 50 67 75 87 ", byteArrayOutputStream.toString());

        byteArrayOutputStream.reset();

        // preorder should print 50 25 12 37 75 67 87
        tree.print(BinaryTree.PrintOrder.PREORDER);
        printStream.flush();
        assertEquals("50 25 12 37 75 67 87 ", byteArrayOutputStream.toString());

        byteArrayOutputStream.reset();

        // postorder should print 12 37 25 67 87 75 50
        tree.print(BinaryTree.PrintOrder.POSTORDER);
        printStream.flush();
        assertEquals("12 37 25 67 87 75 50 ", byteArrayOutputStream.toString());

        // restore stdout
        System.setOut(oldPrintStream);
    }
}
