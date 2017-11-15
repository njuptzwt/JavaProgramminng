package com.heap;

import com.sort.SelectSortHelper;

/**不需要实现额外的空间来复制排序的数组，而是直接在待排序的数组中直接进行堆排序
 * 比前面两种方式好点
 * 以数组0代表根元素！！注意和构造堆中的数据[1]下标1开始区别
 * 此时i节点的leftchild(2*i+1),rightChild(2*i+2),节点的下标最大值length-1;
 * 第一个非叶子结点的下标为（length-2)/2；从它开始heapify
 * Created by 18362 on 2017/11/14.
 */
public class HeapSort {
    //length传入的是下标
    private static void shiftDown(Comparable []arr,int length,int index)//Comparable接口的实例化，Integer,Double和实现Comparable的接口类
    {
        //这边可以仿照插入排序进行优化
        while(2*index+1<=length)//节点是否有左孩子
        {
            int j=2*index+1;
            if(j+1<=length&&arr[j+1].compareTo(arr[j])>0)
                j++;
            if(arr[index].compareTo(arr[j])>=0)
                break;
            swap(arr,index,j);
            index=j;
        }
    }
    //插入排序的优化！！方案同样适用这里
    private static void shiftDown2(Comparable []arr,int length,int index)
    {
        Comparable temp=arr[index];
        while(2*index+1<=length)
        {
            int j=2*index+1;
            if(j+1<=length&&arr[j+1].compareTo(arr[j])>0)
                j++;
            if(arr[index].compareTo(arr[j])>=0)
                break;
            arr[index]=arr[j];
            index=j;
        }
        arr[index]=temp;
    }
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        //开始构造最大堆
        for(int j=(length-2)/2;j>=0;j--)
            shiftDown2(arr,length-1,j);
        //开始堆排序
        for(int i=length-1;i>0;i--)
        {
            swap(arr,0,i);//交换数据之后维护的堆少一个元素
            shiftDown2(arr,i-1,0);//堆维护
        }
    }
    private static void swap(Comparable []arr,int l,int r)
    {
        Comparable temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SelectSortHelper.generateRandomArray(N, 0, 100000);
        SelectSortHelper.testSort(arr, "com.heap.HeapSort");
        return;
    }
}
