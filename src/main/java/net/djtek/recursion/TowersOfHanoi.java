package net.djtek.recursion;

public class TowersOfHanoi {
    public static void printSteps(String startPeg, String tempPeg, String endPeg, int numRings) {
        if (numRings == 1){
            System.out.println(String.format("%s -> %s", startPeg, endPeg));
            return;
        }

        // move n-1 rings from start to temp
        printSteps(startPeg, endPeg, tempPeg, numRings - 1);

        // move ring from start to end
        System.out.println(String.format("%s -> %s", startPeg, endPeg));

        // move n-1 rings from temp to end
        printSteps(tempPeg, endPeg, startPeg, numRings - 1);
    }
}
