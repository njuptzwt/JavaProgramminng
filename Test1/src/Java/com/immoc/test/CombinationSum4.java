package com.immoc.test;

import java.util.Arrays;

/**dp算法求解
 * Created by 18362 on 2017/11/7.
 */
public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
    int length=nums.length;
    if(length<=0||target<0)
        return 0;
    if(target==0)
        return 1;
    Arrays.sort(nums);
    int []result=new int[target+1];
    result[0]=1;
    for(int i=1;i<=target;i++)
        for(int j=0;j<nums.length&&i>=nums[j];j++)//这种逻辑下，数组需要按照顺序排好队
            result[i]+=result[i-nums[j]];
    return result[target];
    }
    public static void main(String args[])
    {
       
    }
}
