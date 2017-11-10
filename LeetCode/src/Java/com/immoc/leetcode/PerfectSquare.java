package com.immoc.leetcode;



/**
 * 直接使用动态规划的做法，从下往上，和IntegerBreak的思路一致
 *递归方法+
 * f(n)=min(f(n-a[0]),f(n-a[1]),.....f[n-a[n])+1;递推表达式
 * * Created by 18362 on 2017/11/3.
 */
public class PerfectSquare {
    public static int numSquares(int n) {
        int []f=new int[n+1];
        for(int i=0;i<=n;i++)
            f[i]=100000;
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=Math.sqrt(i);j++)
                f[i]=Math.min(f[i],f[i-j*j]);
            f[i]++;//差点在这里出错了
        }
        return f[n];
    }
    public static void main(String args[])
    {
        int n=16;
        System.out.println(numSquares(n));
    }
}
