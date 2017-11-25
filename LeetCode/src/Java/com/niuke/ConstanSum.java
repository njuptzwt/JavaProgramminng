package com.niuke;

import java.util.Scanner;

/**最大连续和，动态规划
 * Created by 18362 on 2017/11/24.
 */
public class ConstanSum {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int res=sc.nextInt();//第一个元素
            for(int i=1;i<n;i++)
                res=Math.max(res,0)+sc.nextInt()>0?sc.nextInt():0;
        }
        System.out.println();
    }
}
