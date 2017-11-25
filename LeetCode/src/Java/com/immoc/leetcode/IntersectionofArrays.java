package com.immoc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18362 on 2017/11/25.
 */
public class IntersectionofArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for(int i=0;i<nums1.length;i++)
            set.add(nums1[i]);
        for(int j=0;j<nums2.length;j++)
            if(set.contains(nums2[j]))
                res.add(nums2[j]);
        int []result=new int[res.size()];
        int i=0;
        for(Integer temp:res)
            result[i++]=temp;
        return result;
    }
    public static void main(String args[])
    {
        int []nums1={1,2,1,2};
        int []nums2={2,2};
        int []result=intersection(nums1,nums2);
        for(int te:result)
            System.out.println(te);
    }
}
