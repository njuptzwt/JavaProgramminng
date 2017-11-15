package com.heap;


import com.sort.SelectSortHelper;

/**最小堆的实现
 * Created by 18362 on 2017/11/15.
 */
public class MinHeap <T extends Comparable>{
    protected T[] data;//存数数据的数组，定义是从[1]....开始到[n]，[0]不放置元素
    protected int count;//存放最小堆元素的个数
    protected int capacity;//存放的容量上限
    public MinHeap()
    {
    }
    public MinHeap(int capacity)
    {
        data=(T[])new Comparable[capacity+1];//根据容量初始化数组
        this.capacity=capacity;
        count=0;
    }
    //自定义建堆O(N)
    public MinHeap(T []arr)
    {
        int length=arr.length;
        capacity=length;//失误
        count=length;//堆的大小
        data=(T[])new Comparable[length+1];
        for(int i=0;i<length;i++)
            data[i+1]=arr[i];
        for(int i=length/2;i>=1;i--)
            shiftDown(i);//使用heapify方式构建最小堆
    }
    //插入法建堆O(N*LogN)
    public void insert(T temp)
    {
        assert count+1<=capacity;
        data[count+1]=temp;
        count++;
        shiftUp(count);//最小堆的构建
    }
    public T extractMin()
    {
        assert count>=1;
        T res=data[1];
        swap(data,1,count);
        count--;
        shiftDown(1);
        return res;
    }
    private void shiftUp(int index)
    {
        //Comparable temp=data[index];
        while(index>1)//防止死循环
        {
            if(data[index/2].compareTo(data[index])>=0)
            {
                swap(data,index,index/2);
                index=index/2;
            }
            else
                break;//差点死在这里
        }
    }
    //最小堆的重排序！！
    private void shiftDown(int index)
    {
        while(2*index<=count)
        {
            int j=2*index;
            if(j+1<=count&&data[j+1].compareTo(data[j])<0)
                j++;
            if(data[index].compareTo(data[j])<=0)
                break;
            swap(data,index,j);
            index=j;
        }
    }
    private void swap(T[]arr,int l,int r)
    {
        T temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public int getCount()
    {
        return count;
    }
    public boolean isEmpty()
    {
        return count==0;
    }
   public static void main(String []args)
   {
       MinHeap<Integer>minHeap=new MinHeap<Integer>(20);
       for(int i=0;i<20;i++)
           minHeap.insert(30-i);
       SelectSortHelper.printArray(minHeap.data);
       Integer test[]=new Integer[20];
       for(int i=0;i<20;i++)
           test[i]=minHeap.extractMin();
       SelectSortHelper.printArray(test);
   }
}
