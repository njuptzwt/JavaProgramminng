package com.immoc.test;

/**
 * 动态规划，自底向下，动态规划的原理（解决子问题开始）
 * Created by 18362 on 2017/11/3.
 */
public class IntegerBreak1 {
    public static int max3(int a,int b,int c)
    {
        return Math.max(a,Math.max(b,c));
    }
    public int integerBreak(int n) {
        /**
         * 动态规划从子问题解决
         */
        int result[]=new int[n+1];//存放每个子数的最佳
        result[1]=1;
        result[2]=1;
        for(int i=3;i<=n;i++)
           for(int j=1;j<i;j++)
            result[i]=max3(result[i],j*(i-j),j*result[i-j]);//递归的递推式
        return result[n];
    }
}
