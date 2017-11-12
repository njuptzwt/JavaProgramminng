package com.sort;

import java.awt.event.ComponentAdapter;

/**希尔排序，插入排序的扩展，时间复杂度也比较低
 * 可以通过d来使得序列提前变得近乎有序
 * 可以大大减小插入排序的时间
 * d的选取，一般取得是length/2;直到length=1就结束循环
 * Created by 18362 on 2017/11/12.
 */
public class ShellSort {
    public static void sort(Comparable []arr) {
        //第一种使用交换数组的方法实现希尔排序,d从大变小,关键是步长的设计，每一个小组分别进行插入排序，最后一次实现插入排序，效率高
        int length = arr.length;
        int gap = length / 2;
        for (; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                for (; j -gap>= 0; j -= gap) {
                    if (arr[j].compareTo(arr[j - gap]) < 0)
                        SelectSortHelper.swap(arr, j, j - gap);
                    else
                        break;
                }
            }
        }
    }
    //希尔排序第二种方式和插入排序第二种方式一样，移动顺序排序，降低交换的次数，更快！
    public static void sort2(Comparable []arr)
    {
        int length=arr.length;
        int gap=length/2;
        for(;gap>=1;gap=gap/2)
        {
            for(int i=gap;i<length;i++)
            {
                int j=i;
                Comparable temp=arr[i];
                for(;j-gap>=0;j=j-gap)
                {
                    if(arr[j-gap].compareTo(temp)>0)
                        arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }

    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateRandomArray(10000,1,10000);
        SelectSortHelper.testSort(a,"com.sort.ShellSort");
        //sort(a);
        //SelectSortHelper.printArray(a);
    }
}
