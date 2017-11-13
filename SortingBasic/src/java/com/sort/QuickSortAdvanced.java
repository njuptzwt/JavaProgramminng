package com.sort;
import java.util.Arrays;


/**快速排序的优化
 * 1、（归并排序的优化一样，所有有高级排序到底层都可以使用插入排序进行排序）
 * 当数组的长度r-l<=15的时候，可以使用插入排序方法进行排序可以节省时间
 * 2、优化，当快速排序去处理近乎有序的数组的时候，排序效率非常的慢，退化成了O(N*N)的时间复杂度
 * 此时情况是每次都以最小的那个元素为起点，每次只减少了一个元素。。N*N的效率
 * 使用随机元素的排序方式
 * Created by 18362 on 2017/11/13.
 */
public class QuickSortAdvanced {
    public static void insertSort(Comparable []arr,int l,int r)
    {
        if(l>=r)
            return ;
        for(int i=l+1;i<=r;i++)//这边的限制就可以保证数组的不越界问题，不需要额外的第一个判断
        {
            Comparable temp=arr[i];
            int j=i;
            for(;j>l&&arr[j-1].compareTo(temp)>0;j--)
                arr[j]=arr[j-1];
            arr[j]=temp;
        }
    }
    public static int getIndex(Comparable []arr,int l,int r)
    {
        int rand=(int)Math.random()*(r-l)+l;
        SelectSortHelper.swap(arr,l,rand);//优化点，随机的中间值作为起始比较点,明白
        int index=l;
        Comparable temp=arr[l];
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i].compareTo(temp)<0)
            {
                SelectSortHelper.swap(arr,index+1,i);
                index++;
            }
        }
        SelectSortHelper.swap(arr,index,l);
        return index;
    }
    public static void quickSort(Comparable []arr,int l,int r)
    {
        //优化点，r-l小于等于15的时候，使用插入排序
        if(r-l<=15)
        {
            insertSort(arr,l,r);
            return ;
        }
        //快排序
        int index=getIndex(arr,l, r);
        quickSort(arr,l,index-1);
        quickSort(arr,index+1,r);
    }
    public static void sort(Comparable []arr)
    {
        int length=arr.length;
        quickSort(arr,0,length-1);
    }

    public static void main(String args[])
    {
        Integer arr[]=SelectSortHelper.generateRandomArray(1000000,1,100000);
        Integer arr1[]= Arrays.copyOfRange(arr,0,1000000);
        SelectSortHelper.testSort(arr1,"com.sort.QuickSortAdvanced");
        SelectSortHelper.testSort(arr,"com.sort.QuickSortAdvanced");
    }
}
