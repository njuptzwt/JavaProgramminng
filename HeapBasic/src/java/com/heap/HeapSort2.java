package com.heap;

import com.sort.SelectSortHelper;

/**需要开辟额外的空间data构造最大堆来实现数组的排序
 * Created by 18362 on 2017/11/14.
 */
public class HeapSort2 {
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        MaxHeap<Comparable>maxHeap=new MaxHeap<Comparable>(arr);
        for(int i=length-1;i>=0;i--)
            arr[i]=maxHeap.extractMax();
    }
    public static void main(String args[])
    {
        int N=1000000;
        Integer []arr= SelectSortHelper.generateRandomArray(N,1,1000000);
        SelectSortHelper.testSort(arr,"com.heap.HeapSort2");
    }
}
