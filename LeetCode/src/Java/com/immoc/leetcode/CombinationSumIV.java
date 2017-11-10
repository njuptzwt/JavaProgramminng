package com.immoc.leetcode;

/**CombinationSum4
 * 求给定数组的组合数序列
 * Created by 18362 on 2017/11/7.
 */
public class CombinationSumIV {
    private static  int[]memo;
    public static int combination(int[] nums,int target)
    {
        if(target==0)
            return 1;
        if(memo[target]!=-1)
            return memo[target];//标记语句
        int result=0;
        for(int i=0;i<nums.length&&target>=nums[i];i++)
            result+=combination(nums,target-nums[i]);
        memo[target]=result;//记忆话搜索的过程
        return result;
    }
    public static int combinationSum4(int[] nums, int target) {
    int length=nums.length;
    if(length<=0||target<=0)
        return 0;
    memo=new int[target+1];
    for(int i=0;i<=target;i++)
        memo[i]=-1;
    return combination(nums,target);
    }
    public static void main(String args[])
    {
        int[]num=new int[3];
        num[0]=1;num[1]=2;num[2]=3;
        System.out.println(combinationSum4(num,4));
    }
}
