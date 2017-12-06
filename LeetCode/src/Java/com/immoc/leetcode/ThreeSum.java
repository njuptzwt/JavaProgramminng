package com.immoc.leetcode;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**三个数的和=0，使用sort函数对所给的数组进行排序
 * Created by 18362 on 2017/12/6.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);//进行字典排序，升序排序，如果需要可以自己定义排序算法
        List<List<Integer>>res=new LinkedList<>();
        int i=0;//标志位（小于0的标志位)
        for(;i<num.length&&num[i]<0;i++);
        for(int j = 0; j<=(i< num.length-3 ?i:num.length-3); j++)
        {
            //开始从当前位置开始搜寻
            if(j==0||num[j]!=num[j-1])//防止重复的数组元素
            {
                int lo=j+1,hi=num.length-1;
                int sum=0-num[j];
                if(num[lo]+num[hi]==sum)
                {
                    res.add(Arrays.asList(num[j],num[lo],num[hi]));//添加元素
                    while(lo<hi&&num[lo]==num[lo+1])lo++;
                    while(lo<hi&&num[hi]==num[hi-1])hi--;//找到下一个标定点
                }
                else if(num[lo]+num[hi]<sum)
                    lo++;//比大小，和快速排序的思想很像
                else
                    hi--;
            }
        }
        return res;
    }
}
