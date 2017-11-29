package com.immoc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18362 on 2017/11/29.
 */
public class IsHappy {
    public static  boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(true)
        {
            int sum=0;
            if(n==1)
                return true;
            if(set.contains(n))
                return false;
            set.add(n);
            while(n>0)
            {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            n=sum;
        }
    }
    public static void main(String args[])
    {
        int a=100;
        System.out.println(isHappy(a));
    }
}
