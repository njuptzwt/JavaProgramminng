package com.sort;

/**快排的基本方案（1），O(N*logN)的算法
 * 每次使用待排序序列的第一个项为标准，以该数据为标准分成左右两堆数据，一个全大于，一个全小于
 * Created by 18362 on 2017/11/12.
 */
public class QuickSort {
    private static int getIndex(Comparable []arr,int l,int r)
    {
        int index=l;//记录比当前值小的数的最大的下标，赋予初始值
        Comparable temp=arr[l];
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i].compareTo(temp)<0)
            {
                SelectSortHelper.swap(arr,++index,i);//快速排序的第一版本的核心思想
            }
        }
        SelectSortHelper.swap(arr,l,index);
        return index;
    }
    private static void quickSort(Comparable []arr,int l,int r)
    {
        if(l>=r)
            return;
        int index=getIndex(arr,l,r);
        quickSort(arr,l,index-1);//左边快速排序
        quickSort(arr,index+1,r);//右边快速排序递归的处理流程，方式！
    }
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        quickSort(arr,0,length-1);
    }
    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateRandomArray(1000000,1,100000);
        SelectSortHelper.testSort(a,"com.sort.QuickSort");
    }
}
