package com.heap;

/**实现在数组中找出排名前100的元素（最小堆栈的思想),每一次维护一个100或者小于100的最小堆，每次把新加入的小元素扔掉
 * 实现在数组中找出排名后100名的元素（最大对思想），每次维护一个100或者小于100的最大堆，每次把新加入的大的元素扔掉
 * 快排实现的效率O(N*logN)，堆实现的效率是O(N*logM)
 * Created by 18362 on 2017/11/16.
 */
public class HeapSort5 <T extends Comparable>{
    private MinHeap<Comparable> minHeap=new MinHeap<>(100);

    public void getNumber(T []arr)
    {
        int length=arr.length;
        for(int i=0;i<100;i++)
            minHeap.insert(arr[i]);//前100个元素构造成最大堆
        for(int i=100;i<length;i++)
        {
            if(arr[i].compareTo(minHeap.data[1])>0)
            {
                minHeap.data[1]=arr[i];
                minHeap.shiftDown(1);//始终踢掉一个元素，再重新排列！保持100个
            }
        }
    }
}
