package net.djtek.misc;

import org.junit.*;

public class PascalsTriangleTests {
    @Test
    public void printTest(){
        PascalsTriangle triangle = new PascalsTriangle(10);
        triangle.print();
    }
}
