package com.niuke;

import java.util.Scanner;

/**假设f(n)是跳到第n个木桩需要的最小跳数，动态规划的方法!思路很简单
 * Created by 18362 on 2017/11/20.(思路很简单的）很容易做，动态规划的类型
 */
public class Jump {
    public static int jump(int []arr)
    {
        int length=arr.length;
        int []result=new int[length+1];
        for(int i=0;i<length+1;i++)
            result[i]=100000;
        result[0]=0;
        for(int j=1;j<=length-1;j++) {
            if (arr[j] != 0) {
                int temp=(0>=j-5?0:j-5);
                for (int k = j - 1; k >= temp; k--)
                    if (arr[k] >=j-k)
                        result[j]=Math.min(result[j],result[k]);
                result[j]++;
            }
        }
        int temp=(0>=length-5?0:length-5);
        for(int k=length-1;k>=temp;k--)
            if(arr[k]>=length-k)
                result[length]=Math.min(result[length],result[k]);
        if(result[length]+1>=100000)
            return -1;
        else
            return result[length]+1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int count=sc.nextInt();
            int arr[]=new int[count];
            for(int i=0;i<count;i++)
                arr[i]=sc.nextInt();
            System.out.println(jump(arr));
        }
    }
}
