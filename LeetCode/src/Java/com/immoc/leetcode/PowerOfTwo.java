package com.immoc.leetcode;

/**
 * Created by 18362 on 2017/11/25.
 */
public class PowerOfTwo {
    public static boolean isPowerOfFour(int num) {
        return Integer.toBinaryString(num).matches("1(0)*");
    }
    public static void main(String args[])
    {
        System.out.println(isPowerOfFour(8));
    }
}
