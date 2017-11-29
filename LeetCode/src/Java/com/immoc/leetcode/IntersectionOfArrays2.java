package com.immoc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 18362 on 2017/11/29.
 */
public class IntersectionOfArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< nums1.length;i++)
        {
            if(map.get(nums1[i])!=null)
                map.put(nums1[i],map.get(nums1[i])+1);
            else
                map.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i])&&map.get(nums2[i])!=0)
            {
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int []res=new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
    return res;
    }
    public static void main(String args[])
    {
       int []nums1={1};
       int []nums2={1,1};
        int[] res=intersect(nums1,nums2);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
