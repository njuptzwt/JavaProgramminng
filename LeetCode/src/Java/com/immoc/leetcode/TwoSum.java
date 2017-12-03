package com.immoc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 18362 on 2017/12/2.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();//新建hash表,默认16位的数据，key-value可以为空
        int []res=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=null)
            {
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            map.put(nums[i],i);//防止数据的覆盖，思想很重要
        }
        return res;
    }
    public static void main(String args[])
    {
        int []nums={2,7,11,15};
        int []res=twoSum(nums,9);
        for(int a:res)
            System.out.println(a);
    }
}
