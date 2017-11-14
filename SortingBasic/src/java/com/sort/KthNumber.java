package com.sort;
/**找一个数组中的第k个大的元素
 * 1、找一个数组中的最大元素或者最小的元素，理想的时间复杂度O(n)
 * 2、找一个数组中的第k个大小的元素，可以先按照快速排序得到有序的序列，然后找出第k个值
 * 3、改进方案，利用快速排序的思想，可以在o(2*n)的时间复杂度下去完成排序
 * Created by 18362 on 2017/11/14.
 */
public class KthNumber {
    private static int partion(Comparable []arr,int l,int r)
    {
        int rand=(int)Math.random()*(r-l)+l;
        swap(arr,l,rand);
        Comparable temp=arr[l];
        int i=l+1;
        int j=r;
        while(true)
        {
          while(i<=r&&arr[i].compareTo(temp)<0)
              i++;
          while(j>=l+1&&arr[j].compareTo(temp)>0)
              j--;
          if(i>j)
              break;
          swap(arr,i,j);
          i++;
          j--;
        }
        swap(arr,j,l);
        return j;
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    private static void sort(Comparable []arr,int l,int r,int k)
    {
        if(l>=r)
            return ;
        int p=partion(arr,l,r);
        if(p==k-1)
            return;
        else if(p<k-1)
            sort(arr,p+1,r,k);
        else
            sort(arr,l,p-1,k);
    }
    public static Comparable getKnumber(Comparable []arr,int k)
    {
        int length=arr.length;
        sort(arr,0,length-1,k);
        return arr[k-1];
    }
    public static void main(String args[])
    {
        Integer arr[]=SelectSortHelper.generateRandomArray(30,1,50);
        SelectSortHelper.printArray(arr);
        System.out.println(getKnumber(arr,10));
        QuickSort2.sort(arr);
        SelectSortHelper.printArray(arr);
    }
}
