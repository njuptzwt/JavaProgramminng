package com.immoc.leetcode;

/**
 * Created by 18362 on 2017/12/10.
 */
public class RemoveNumbers {
    public static void swap(int []arr,int l,int r)
    {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
    public static int removeElement(int[] nums, int val) {
        int l=0;
        int r=nums.length-1;
        while(true)
        {
            while(l<nums.length&&nums[l]!=val)l++;
            while(r>=0&&nums[r]==val)r--;
            if(l<=r)
            {
                swap(nums,l,r);
                l++;
                r--;
            }
            else
                break;
        }
        return l;
    }
    public static void main(String args[])
    {
        int nums[]={};
        System.out.println(removeElement(nums,3));
    }
}
