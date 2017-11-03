package com.immoc.test;

/**
 * 使用递归方式做大数拆解的题目
 * Created by 18362 on 2017/11/3.
 */
public class IntegerBreak {
    private static int[] memo;//记忆数组
    public static int max3(int a,int b,int c)
    {
        return Math.max(a,Math.max(b,c));
    }
    public static int Break(int n)
    {
        //递归调用
        if(n==1||n==2)
            return 1;
        if(memo[n]>0)
            return memo[n];
        else
        {
            int result=-1;
            for(int i=1;i<n;i++)
                result=max3(result,i*(n-i),i*Break(n-i));
            memo[n]=result;
            return result;
        }
    }
    public static int integerBreak(int n) {
        memo=new int[n+1];//记忆化数
     return Break(n);
    }
    public static void main(String args[])
    {
        int n=10;
        System.out.println(integerBreak(n));
    }
}
