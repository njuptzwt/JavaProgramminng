package com.immoc.leetcode;

/**使用递归的方法加上记忆话搜索的算法
 *
 * Created by 18362 on 2017/11/8.
 */
public class LISII {
    private static int[] memo;
    public  static int lis(int nums[],int index)
    {
        //下标为index的数字作子字符串的结尾能够获得的最长序列的值
        if(memo[index]>0)
            return memo[index];
        int result=1;
        for(int j=0;j<index;j++)
            if(nums[index]>nums[j])
                result=Math.max(result,lis(nums,j)+1);
        memo[index]=result;
        return result;
    }
    public static int lengthOfLIS(int[] nums)
    {
        int length=nums.length;
        if(length==0)
            return 0;
        int result=0;
        memo=new int[length];
        memo[0]=1;
        result=lis(nums,nums.length-1);
        return result;
    }
    public static void main(String args[])
    {
        int nums[]={2,2,2,2,2};
        System.out.println(lengthOfLIS(nums));
        int a=1;

    }
}
