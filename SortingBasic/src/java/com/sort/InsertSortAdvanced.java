package com.sort;

import java.util.Arrays;

/**插入排序的优化
 * 优化时间的复杂度
 * Created by 18362 on 2017/11/10.
 */
public class InsertSortAdvanced {
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        for(int i=1;i<length;i++) {
            Comparable temp=arr[i];
            int j=i;
            for (; j > 0&&arr[j-1].compareTo(temp)>0; j--) {
                 arr[j]=arr[j-1];//优化交换数据的使用次数
            }
            arr[j]=temp;//
        }
    }
    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateNearlyOrderedArray(10000,10);
        Integer b[]= Arrays.copyOf(a,a.length);
        SelectSortHelper.testSort(a,"com.sort.Templatesort");
        SelectSortHelper.testSort(b,"com.sort.InsertSortAdvanced");
    }
}
