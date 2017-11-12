package com.sort;

import java.util.Arrays;

/**插入排序的代码
 * Created by 18362 on 2017/11/10.
 */
public class InsertSort {
    public static void sort(Comparable []arr)
    {
        //插入排序的核心思想和打扑克的时候一样，按照顺序插入扑克牌（找到合适的插入位置）
        //每一次都从插入的当前位置开始和前面的比较
        int length=arr.length;
        for(int i=1;i<length;i++)
            for(int j=i;j>0;j--)
            {
                if(arr[j].compareTo(arr[j-1])<0)
                    SelectSortHelper.swap(arr,j,j-1);
                else
                    break;
            }
    }
    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateRandomArray(10000,1,10000);
        Integer b[]= Arrays.copyOf(a,a.length);
        SelectSortHelper.testSort(a,"com.sort.Templatesort");
        SelectSortHelper.testSort(b,"com.sort.InsertSort");
    }
}
