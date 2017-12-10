package com.immoc.leetcode;

/**
 * Created by 18362 on 2017/12/10.
 */
public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
    int k=0;//新的标志点
        int l=0;
        int r=nums.length-1;
        for(;l<=r;l++)
            if(nums[k]!=nums[l])
            {
                k++;
                nums[k]=nums[l];
            }
            return k+1;
    }
    public static void main(String args[])
    {
        int arr[]={2,2,2,3,3,3,4,4};
        System.out.println(removeDuplicates(arr));
    }
}
