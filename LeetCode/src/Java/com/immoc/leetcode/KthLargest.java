package com.immoc.leetcode;

/**
 * Created by 18362 on 2017/12/10.
 */
public class KthLargest {
    public int  findindex(int []arr,int l,int r)
    {
        assert l<=r;
        int index=(int)Math.random()*(r-l);
        swap(arr,l,index);
        int temp=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i]>temp)
            {
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr,j,l);
        return j;
    }
    public void swap(int []arr,int l,int r)
    {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public int findKthLargest(int[] nums, int k) {
    int res=findindex(nums,0,nums.length-1);
    if(res==k-1)
        return nums[k-1];
    else if(res>k-1)
        return nums[findindex(nums,0,res-1)];
    else
        return nums[findindex(nums,res+1,nums.length-1)];
    }
}
