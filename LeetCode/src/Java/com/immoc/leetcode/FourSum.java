package com.immoc.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**4个数字的和等于指定的target值,跳步法执行
 * 因为先对数组进行了排序，可以使用跳过的方法去重复的值
 * 也可以使用set集合的去重复性质进行去重的操作
 * 3sum的思路求解问题
 * Created by 18362 on 2017/12/7.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res=new LinkedList<>();
    for(int j=0;j<nums.length-3;j++)
    {
        //找出两个标定点集合
        if(j==0||nums[j]!=nums[j-1])
        {
            for(int i=j+1;i<nums.length-2;i++)
            {
                if(i==j+1||nums[i]!=nums[i-1])
                {
                    int lo=i+1;
                    int hi=nums.length-1;
                    int sum=target-nums[j]-nums[i];
                    while(lo<hi) {
                        if (nums[lo] + nums[hi] == sum) {
                            res.add(Arrays.asList(nums[j],nums[i],nums[lo],nums[hi]));
                            while(lo<hi&&nums[lo]==nums[lo++])lo++;
                            while(lo<hi&&nums[hi]==nums[hi--])hi--;
                            lo++;hi--;
                        }
                        else if(nums[lo]+nums[hi]<sum)
                                lo++;
                        else
                                hi--;
                    }
                }
            }
        }
    }
    return res;
    }
    public static void main(String args[])
    {
        int []s={1, 0, -1, 0,-2, 2};
        List<List<Integer>> res=fourSum(s,0);
        System.out.println(res.size());
        for(int i=0;i<res.size();i++)
        {
            for(int j=0;j<4;j++)
                System.out.print(res.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
