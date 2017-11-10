package com.immoc.leetcode;

import java.util.*;

/**
 * 查找共有多少中的组合构成最长子序列
 * 构造两个数组dp[i]记录的是下标为i的元素为子序列的时候构成的最大子序列长度
 * count[i]代表i为下标的最大子序列的个数
 * Created by 18362 on 2017/11/8.
 */
public class NumberofLIS {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int dp[] = new int[length];
        int count[] = new int[length];
        for (int i = 0; i < length; i++)
            dp[i] = count[i] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];//理解清楚逻辑思路就很简单，count[i]只跟length[i]-1且nums[j]<nums[i]的j的种类有关
                    } else if (dp[i] == dp[j] + 1)
                        count[i] += count[j];
                }
            }
        }
        int max = -1;
        int result = 0;
        for (int temp : dp)
            max = Math.max(max, temp);
        for (int i = 0; i < length; i++)
            if (dp[i] == max)
                result += count[i];
        return result;
    }
}
