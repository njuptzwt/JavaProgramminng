package com.sort;

import javax.smartcardio.CommandAPDU;
import java.util.Arrays;

/**冒泡排序算法，每次都比较相邻节点的值然后一直将最大值往后移动
 * Created by 18362 on 2017/11/11.
 */
public class BubbleSort {
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        assert length>0;
        for(int i=length-1;i>=1;i--)//冒泡排序后面排好顺序的元素不再考虑
            for(int j=0;j<i;j++)
                if(arr[j].compareTo(arr[j+1])>0)
                    SelectSortHelper.swap(arr,j,j+1);
    }
    public static void main(String args[])
    {
        Integer a[]=SelectSortHelper.generateRandomArray(10000,1,10000);
        SelectSortHelper.testSort(a,"com.sort.BubbleSort");
        //SelectSortHelper.printArray(a);
    }
}
