package com.immoc.leetcode;

import java.awt.font.NumericShaper;

/**
 * Created by 18362 on 2017/12/10.
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int l= nums.length;
        if(l==1)
            return 1;
        int k=2;
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]>=nums[k-1]&&nums[i]>nums[k-2])
                nums[k++]=nums[i];
        }
        return k;
    }
    public static void main(String args[])
    {
        int a[]={1,2,2,2,3,3,3,4,5};
        System.out.println(removeDuplicates(a));
    }
}
