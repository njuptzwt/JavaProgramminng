package com.immoc.test;

import java.util.*;

/**
 * Created by 18362 on 2017/11/8.
 */
public class NumberofLIS {
    public int findNumberOfLIS(int[] nums) {
        int length=nums.length;
        if(length==0)
            return 0;
        int []memo=new int[length];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++)
            memo[i]=1;//初始化
        for(int i=1;i<length;i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    list.add(memo[j]);
            }
            Collections.sort(list);
            int count=0;
            for(Integer a:list)
                if(a==list.get(list.size()-1))
                    count++;
            memo[i]=Math.max(memo[i],list.get(list.size()-1)+1);
        }
        return res;
    }
}
