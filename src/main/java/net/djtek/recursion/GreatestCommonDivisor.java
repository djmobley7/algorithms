package net.djtek.recursion;

/**
 * Created by danmobley on 9/30/17.
 */
public class GreatestCommonDivisor {
    public static long compute(long x, long y){
        if (y > x){
            return _compute (y, x);
        }
        return _compute (x, y);
    }

    private static long _compute(long x, long y){
        return y == 0 ? x : _compute(y, x % y);
    }
}
