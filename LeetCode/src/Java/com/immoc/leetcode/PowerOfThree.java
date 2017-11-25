package com.immoc.leetcode;

/**
 * Created by 18362 on 2017/11/25.
 */
public class PowerOfThree {
    //简单的算法！效率更高！
    public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
    public static boolean isPowerOfThree(int n) {
    if(n==1)
        return true;
    if(n%3!=0)
        return false;
    return isPowerOfThree(n/3);
    }
    public static void main(String args[])
    {
        int a=1;
        for(int i=0;i<30;i++)
            a*=2;
        System.out.println(a);
    }
}
