package com.immoc.leetcode;


/**Longest Incresing Sequences
 *最长上升子序列的求法，动态规划求解LIS
 * 思路：
 * F(i)表示第i个数据作为字符串的结尾能够取得的最大的字符串..思考的方式，递推关系式
 * F(i)=max(F(j)+1,i>j,nums[i]>nums[j])
 * Created by 18362 on 2017/11/8.
 */
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int length=nums.length;
        if(length==0)
            return 0;
        int []memo=new int[length];
        for(int i=0;i<length;i++)
            memo[i]=1;//初始化
        for(int i=1;i<length;i++)
            for(int j=0;j<i;j++)
                if(nums[i]>nums[j])
                memo[i]=Math.max(memo[i],memo[j]+1);
        int res=1;
        for(int i=0;i<length;i++)
            res=Math.max(res,memo[i]);
        return res;
    }
    public static void main(String args[])
    {
        int nums[]={1,3,5,4,7};
        System.out.println(lengthOfLIS(nums));
    }
}
