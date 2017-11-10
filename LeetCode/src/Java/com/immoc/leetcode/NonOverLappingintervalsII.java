package com.immoc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 使用贪心算法求解动态规划的问题
 * Created by 18362 on 2017/11/9.
 */
public class NonOverLappingintervalsII {
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

    public int eraseOverlapIntervals(Interval[] intervals) {
        int length=intervals.length;
        if(length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end==o2.end)
                    return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });//贪心算法，每次取末边界的点为结尾
        int result=1;
        Interval pre=intervals[0];
        for(int i=1;i<length;i++)
        {
            if(intervals[i].start>=pre.end)
            {
                result++;//结果加1
                pre=intervals[i];//每一次更新前驱
            }
        }
        return length-result;
    }
}
