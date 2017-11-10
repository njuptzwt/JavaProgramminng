package com.immoc.leetcode;

/**环形，需要多判断开始和结尾的冲突情况（只需要考虑这个）
 * public int rob(int[] num) {
 int[][] dp = new int[num.length + 1][2];
 for (int i = 1; i <= num.length; i++) {
 dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
 dp[i][1] = num[i - 1] + dp[i - 1][0];
 }
 return Math.max(dp[num.length][0], dp[num.length][1]);
 }
 dp[i][1] means we rob the current house and dp[i][0] means we don't,so it is easy to convert this to O(1) space

 public int rob(int[] num) {
 int prevNo = 0;
 int prevYes = 0;
 for (int n : num) {
 int temp = prevNo;
 prevNo = Math.max(prevNo, prevYes);
 prevYes = n + temp;
 }
 return Math.max(prevNo, prevYes);
 }
 * Created by 18362 on 2017/11/6.
 */
public class HouseRobberII {
    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
