package com.immoc.leetcode;

/**双指针操作
 * Created by 18362 on 2017/12/10.
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
    int r=nums.length;
    for(int i=0;i<r-1;i++)
    {
        if(nums[i]==0)
        {
            int j=i+1;
            while(j<r&&nums[j]==0)j++;
            if(j<r){
            nums[i]=nums[j];
            nums[j]=0;}
        }
    }
    }
    public static void main(String args[])
    {
        int a[]={0,1,0,3,12};
        moveZeroes(a);
        for(int temp:a)
            System.out.println(temp+" ");
    }
}
