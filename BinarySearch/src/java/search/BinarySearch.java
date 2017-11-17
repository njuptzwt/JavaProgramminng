package search;

import java.util.Date;

/**使用递归和非递归的方法来实现二分搜索
 * Created by 18362 on 2017/11/17.
 */
public class BinarySearch {
    //非递归的方式
    public static int Search(Comparable []arr, Comparable temp)
    {
        //对一个有序的数组进行二分搜索
        int length=arr.length;
        int l=0;
        int r=length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;//中间的数
            if(arr[mid]==temp)
                return mid;
            else if(arr[mid].compareTo(temp)>0)
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;//没有目标值，返回-1
    }
    //返回从下标l到下标r的搜索结果，递归的方式
    public static int Search2(Comparable []arr,int l,int r,Comparable temp)
    {
        if(l>r)
            return -1;
        int mid=l+(r-l)/2;
        if(temp==arr[mid])
            return mid;
        else if (temp.compareTo(arr[mid])<0)
            return Search2(arr,l,mid-1,temp);
        else
            return Search2(arr,mid+1,r,temp);
    }
    public static void main(String args[])
    {
        int N=1000000;
        Integer arr[]=new Integer[N];
        for(int i=0;i<N;i++)
            arr[i]=new Integer(i+1);
        long startTime = System.currentTimeMillis();
        Search(arr,500000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
