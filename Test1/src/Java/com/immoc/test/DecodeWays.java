package com.immoc.test;

/**
 * 实质上是斐波那契数列
 * Created by 18362 on 2017/11/3.
 */
public class DecodeWays {
    public int numDecodings(String s)
    {
        int length=s.length();
        int []total=new int[length+1];
        total[0]=total[1]=total[2]=1;
        for(int i=2;i<=length;i++)
        {
            total[i]=total[i-1]+total[i-2];
        }
        return total[length];

    }
}
