package com.heap;
import com.sort.SelectSortHelper;

/**第一种堆排序的方式，利用构造最大堆的方式进行排序
 * Created by 18362 on 2017/11/14.
 */
public class HeapSort1 {
    //构造最大堆，实现排序
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        MaxHeap<Comparable> maxHeap=new MaxHeap<Comparable>(length);
        for(int i=0;i<length;i++)
            maxHeap.insert(arr[i]);
        for(int j=length-1;j>=0;j--)
        {
            arr[j]=maxHeap.extractMax();
        }
    }
    public static void main(String args[])
    {
        int N=1000000;
        Integer []arr= SelectSortHelper.generateRandomArray(N,1,100000);
        SelectSortHelper.testSort(arr,"com.heap.HeapSort1");
    }
}
