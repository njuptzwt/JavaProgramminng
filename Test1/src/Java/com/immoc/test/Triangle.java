package com.immoc.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划，在三角形中寻找最小数的问题
 * Created by 18362 on 2017/11/2.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int size=triangle.size();//数据有几行
        List<Integer> list=triangle.get(size-1);
        int []result=new int[size];
        for(int i=0;i<size;i++)
            result[i]=list.get(i);//从下往上找
        /**
         * 动态规划的逻辑判断,从下往上走
         */
        for(int i=triangle.size()-2;i>=0;i--)
        {
            for(int j=0;j<i+1;i++)
                result[j]=Math.min(result[j],result[j+1])+triangle.get(i).get(j);
        }
        return result[0];
    }
}
