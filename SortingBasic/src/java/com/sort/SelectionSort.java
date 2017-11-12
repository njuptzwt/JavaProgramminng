package com.sort;

/**选择排序很简单
 * Created by 18362 on 2017/11/3.
 */
public class SelectionSort {
    public static void selectionSort(int []a)
    {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            int minIndex=i;
            for(int j=i+1;j<n;j++)
                if(a[j]<a[minIndex])
                    minIndex=j;
            int temp=a[i];
            a[i]=a[minIndex];
            a[minIndex]=temp;
        }
    }
    public static void main(String args[])
    {
        int a[]={1,2,3,4,5,6,7,8,9,3};
        for(int i=0;i<10;i++)
            a[i]=10-i;
        selectionSort(a);
        for(int i=0;i<10;i++)
            System.out.println(a[i]);
    }
}
