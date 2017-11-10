package com.immoc.leetcode;

/**
 * dp[i]以第i个数字结尾的数据传中最长的wiggle字符串
 * Created by 18362 on 2017/11/10.
 */
public class wigggleMaxlength {
    public static int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return 1;
        int[] nums1 = new int[length - 1];
        int dp[] = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            nums1[i] = nums[i + 1] - nums[i];//
        }
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums1[i] != 0) {
                dp[i] = 1;
                temp = i;
                break;
            }
        }
        for (int i = temp + 1; i < length - 1; i++) {
            if (nums1[i] == 0)
                dp[i] = dp[i - 1];
            else {
                for (int j = 0; j < i; j++)
                    if (nums1[i] * nums1[j] < 0)//相邻两个不同时为0
                        dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        //返回最大值加1
        int res = -1;
        for (int j = 0; j < length - 1; j++)
            res = Math.max(res, dp[j]);
        return res + 1;//最保险

    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int result = wiggleMaxLength(nums);
        System.out.println(result);
    }
}
