package com.heap;


import com.sort.SelectSortHelper;

import javax.smartcardio.CommandAPDU;

/**最小堆的排序
 * Created by 18362 on 2017/11/15.
 */
public class HeapSort3 {
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        MinHeap<Comparable>minHeap=new MinHeap<Comparable>(arr.length);
        for(int i=0;i<length;i++)
            minHeap.insert(arr[i]);
        for(int i=0;i<length;i++)
            arr[i]=minHeap.extractMin();
    }
    public static void sort2(Comparable []arr)
    {
        int length=arr.length;
        MinHeap<Comparable>minHeap=new MinHeap<Comparable>(arr);//使用自定义构造堆的方式heapify方式
        for(int i=0;i<length;i++)
            arr[i]=minHeap.extractMin();
    }

    public static void main(String args[])
    {
        Integer []arr= SelectSortHelper.generateRandomArray(20,1,50);
        SelectSortHelper.printArray(arr);
        HeapSort3.sort2(arr);
        SelectSortHelper.printArray(arr);
    }
}
