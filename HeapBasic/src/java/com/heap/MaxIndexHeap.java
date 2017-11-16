package com.heap;
/**最大的索引堆
 * 还是以[1]索引的序号为1开始讨论
 * 为什么要引入索引堆
 * 1、索引堆存储的值是索引的序号，数据交换的空间耗费比其他的小
 * 2、索引堆存储能狗方便的找到元素据，元素据的位置不会变，对元素据的修改O(1)的时间复杂度
 * 反向搜索的思想：
 * reverse[i]记录原来下标i的数据在（新堆）索引数组中的位置。方便更新数据！!
 * Created by 18362 on 2017/11/16.
 */
public class MaxIndexHeap<T extends Comparable> {
    protected T data[];//存储数据值
    protected Integer indexes[];//存储索引的数组
    protected Integer reverse[];//存储索引的逆序值
    protected int capacity;//容量
    protected int count;//堆的实时数据大小

    public MaxIndexHeap()
    {

    }
    public int size()
    {
        return count;
    }
    public Boolean IsEmpty()
    {
        return count==0;
    }
    // 获取最大索引堆中的堆顶元素
    public  T getMax(){
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1]-1;
    }
    //插入操作
    public void insert(int i,T temp)
    {
        assert i+1<=capacity;
        i++;
        data[i]=temp;
        indexes[i]=i;//新加入的数据，他的索引值对应的就是最后一个
        reverse[i]=i;//新加入的数据，最后一个数据的起始反向数据就是自己的初始序号，reverse[i]的意思下标为i的数据在indexes中的位置
        count++;//元素的个数加1
        shiftUp(i);//对索引i进行shiftUp()
    }
    private void shiftUp(int k)
    {
        while(k/2>=1)
        {
            if(data[indexes[k/2]].compareTo(data[indexes[k]])<0)
            {
                swap(indexes,k/2,k);
                reverse[indexes[k/2]]=k/2;
                reverse[indexes[k]]=k;//反向查找的思路！！
                k=k/2;
            }
            else
                break;
        }
    }
    //提取索引的操作或者说是提取堆头的元素
    public int extractMax()
    {
        int res=indexes[1];//需要返回的元素的索引
        swap(indexes,1,count);
        reverse[count]=0;
        reverse[indexes[1]]=1;
        count--;
        shiftDown(1);
        return res;
    }
    //索引堆的shiftDown的操作
    private void shiftDown(int k)
    {
        while(2*k+1<=count)
        {
            int j=2*count+1;
            if(j+1<=count&&data[indexes[j+1]].compareTo(data[indexes[j]])>0)
                j++;
            if(data[indexes[k]].compareTo(data[indexes[j]])>=0)
                break;
            swap(indexes,k,j);//交换索引
            reverse[indexes[k]]=k;
            reverse[indexes[j]]=j;//完毕，交换的数据
            k=j;
        }
    }
    //索引堆的change操作，操作系统的常用功能，对一个任务的优先级别进行提升，然后重新进行最大堆的实现
    public void change(int index,T changed)
    {
        index++;//对外部索引的维护操作
        data[index]=changed;//修改的数据
        int j=1;
        for(;j<=count&&index!=indexes[j];j++);//时间复杂度O(n)
        shiftUp(j);
        shiftDown(j);
    }
    private static void swap(Comparable []arr,int l,int r)
    {
        Comparable temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
