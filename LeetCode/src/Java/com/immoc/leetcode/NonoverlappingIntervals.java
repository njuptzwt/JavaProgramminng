package com.immoc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 删减至少几个区间可以使得剩余的区间没有重复的区间
 * 1、动态规划
 * 2、贪心算法
 * DP可以转化为f(n)，当第n个区间作为最后一个区间的时候，能构成不重复子区间的最大个数
 * 可以转化成最长递增子序列的问题（这种题目一定要考虑集合是否有顺序性的要求）
 * Created by 18362 on 2017/11/9.
 */
public class NonoverlappingIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    //comparator接口实现类的重排序
    public int eraseOverlapIntervals(Interval[] intervals) {
        int length = intervals.length;
        if (length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });//实现数组或者说是集合类的重排列
        int dp[] = new int[length];//第i个区间是最后一个区间的时候，最多保留几个子区间使得不重叠
        for(int k=0;k<length;k++)
            dp[k]=1;
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i-1];
                for (int j = 0; j < i; j++)
                    if(intervals[i].start>=intervals[j].end)
                        dp[i]=Math.max(dp[i],dp[j]+1);//最长递增子序列LIS的扩展
        }
        int res=-1;
        for(int i:dp)
            res=Math.max(res,i);
        return intervals.length-res;
    }
}