package com.immoc.leetcode;

/**硬币的最小构成方案(动态规划）
 * Created by 18362 on 2017/11/3.
 */
public class Coins {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if (length == 0 || amount <= 0)
            return -1;
        int[] result = new int[amount + 1];
        result[0] = 0;
        int max = 10000;
        for (int i = 1; i <= amount; i++) {
            result[i] = max;
            for (int j = 0; j < length; j++)
                result[i] = Math.min(result[i], i - coins[j] >= 0 ? result[i - coins[j]] : max);
            result[i]++;
        }
        if (result[amount] >= max)
            return -1;
        else
            return result[amount];
    }
}
