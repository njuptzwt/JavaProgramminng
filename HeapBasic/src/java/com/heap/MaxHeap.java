package com.heap;

/**最大堆的经典数据结构的构建
 * 设计成数组形式（数组的第一个数不放任何东西）
 * 从i=1......n去放置要放的堆元素
 * 这种放置思想下，leftChild(i)是数组下标为2*i的元素，rightChild是数组下标为2*i+1的数组元素
 * 一个元素的父亲元素的位置parent(i),是下标为i/2的数组元素
 *设计到可以比较的元素，一律要使用Comparable这个接口
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
    //定义堆元素的插入操作
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
    //堆的调整操作
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
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );
        System.out.println(maxHeap.getSize());
    }
}
