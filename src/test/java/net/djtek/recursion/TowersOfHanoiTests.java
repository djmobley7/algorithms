package net.djtek.recursion;

import org.junit.*;
import static org.junit.Assert.*;

public class TowersOfHanoiTests {
    @Test
    public void printStepsTests(){
        TowersOfHanoi.printSteps("S", "T", "E", 3);
    }
}
