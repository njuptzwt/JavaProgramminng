package com.heap;

import com.sort.SelectSortHelper;
/**只通过数组自行的进行堆排序，不需要开辟额外的存储空间
 * 核心是先构造最大堆，之后每次交换,从数组的下标为0开始
 * Created by 18362 on 2017/11/16.
 */
public class HeapSort4<T extends Comparable> {
    //shiftDown实现最大堆的维护,数组的维护
    private  void shiftDown(Comparable []arr,int length,int k)
    {
        while(2*k+1<=length)
        {
            int j=2*k+1;
            if(j+1<=length&&arr[j+1].compareTo(arr[j])>0)
                j++;
            if(arr[k].compareTo(arr[j])>=0)
                break;
            swap(arr,k,j);
            k=j;
        }
    }
    //最大堆的优化操作，跟插入排序是一样的
    private void shiftDown2(Comparable []arr,int length,int k)
    {
        //优化shiftDown的操作，减少swap的时间，插入排序的优化
        Comparable temp=arr[k];
        while(2*k+1<=length)
        {
            int j=2*k+1;
            if(j+1<=length&&arr[j+1].compareTo(arr[j])>0)
                j++;
            if(temp.compareTo(arr[j])>=0)
                break;
            arr[k]=arr[j];
            k=j;
        }
        arr[k]=temp;
    }
    private void swap(Comparable []arr,int l,int r)
    {
        Comparable t=arr[l];
        arr[l]=arr[r];
        arr[r]=t;
    }
    public  void sort(Comparable []arr)
    {
        int length=arr.length-1;
        int begin=(length-2)/2;//非叶子结点开始执行shiftDown操作
        for(int i=begin;i>=0;i--)
            shiftDown2(arr,length,i);//进行堆的排序
        for(int i=length;i>0;i--)
        {
            swap(arr,0,i);
            shiftDown2(arr,i-1,0);//堆的维护
        }
    }
    public static void main(String []args)
    {
        Integer []arr= SelectSortHelper.generateRandomArray(20,1,50);
        SelectSortHelper.printArray(arr);
        HeapSort4<Integer>heapSort4=new HeapSort4<Integer>();
        heapSort4.sort(arr);
        SelectSortHelper.printArray(arr);
    }
}
