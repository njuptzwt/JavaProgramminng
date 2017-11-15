package com.heap;

/**最大堆的经典数据结构的构建
 * 设计成数组形式（数组的第一个数不放任何东西）
 * 从i=1......n去放置要放的堆元素(传统的O(N*logN）的时间复杂度！！
 * 这种放置思想下，leftChild(i)是数组下标为2*i的元素，rightChild是数组下标为2*i+1的数组元素
 * 一个元素的父亲元素的位置parent(i),是下标为i/2的数组元素
 *设计到可以比较的元素，一律要使用Comparable这个接口
 *
 * Heapify堆调整的操作！！要使得每一个子数都是最大堆！时间复杂度O（n)
 * Created by 18362 on 2017/11/14.
 */
public class MaxHeap <T extends Comparable>
{
    protected T []data;//存放最大堆的数据结构
    protected int count;//堆中的元素
    protected int capacity;
    public MaxHeap(int capacity)
    {
        data=(T[])new Comparable[capacity+1];//Java中的万事万物皆对象，capacity的值为，data[0]不用
        count=0;
        this.capacity=capacity;
    }
    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(T []arr)
    {
        int length=arr.length;
        capacity=length;
        data=(T[])new Comparable[length+1];
        for(int i=0;i<length;i++)
            data[i+1]=arr[i];
        count=length;
        for(int i=length/2;i>=1;i--)
            shiftDown(i);//Heapify操作建堆
    }
    //堆中数据的大小
    public int  getSize()
    {
        return count;
    }
    //堆是否为空
    public Boolean isEmpty()
    {
        return count==0;
    }
    //定义堆元素的插入操作,构建最大堆
    public  void insert(T temp)
    {
        assert count+1<=capacity;
        //比较好的方式应该是，对容量越界之后扩展容量
        /**
         * data1=Arrays.copyOfRange(data,0,101)；
         * capacity=*2;扩充两倍
         * data=(T[])new Comparable[capacity+1];
         * 使用元素的复制，克隆
         * */
        data[count+1]=temp;
        count++;//堆栈元素加1
        shiftUp(count);
    }
    //堆的向上调整操作，插入操作，构建最大堆
    private void shiftUp(int temp)
    {
        while(temp>1&&data[temp/2].compareTo(data[temp])<0)
        {
            swap(data,temp/2,temp);
            temp=temp/2;
        }
    }
    private void swap(T []arr,int i,int j)
    {
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //从堆中返回最小值，从新调整最大堆
    public T extractMax( )
    {
        assert  count>=1;
        T temp=data[1];
        swap(data,1,count);
        count--;
        shiftDown(1);
        return temp;
    }
    //调整最大堆的操作！！shiftDown函数的作用是调整下标i之后的数据为最大堆！！
    //最大堆的调整原理是基于0号元素以后的下标都是最大堆，以此基础上进行调整！！
    private void shiftDown(int index)
    {
        //用while循环控制最大堆的控制，这边不要优化，就很快的速度！！对swap进行优化！！
        while(index*2<=count)//最大堆的最后一层，当某个节点的左孩子有的话讨论，否则我们结束循环
        {
            int j=index*2;//记录交换节点的位置
            while(j+1<=count&&data[j+1].compareTo(data[j])>0)
                j++;
            if(data[index].compareTo(data[j])>=0)
                break;
            swap(data,index,j);
            index=j;//循环操作，这些逻辑！！
        }
    }
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }
}
