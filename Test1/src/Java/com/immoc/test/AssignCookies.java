package com.immoc.test;

import java.util.Arrays;

/**贪心算法解决分饼干的问题
 * Created by 18362 on 2017/11/8.
 */
public class AssignCookies {
    /**
     * g是每一个孩子的贪心值
     * s是每一块饼干的大小
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gindex=g.length-1;
        int sindex=s.length-1;
        int result=0;
        while(gindex>=0&&sindex>=0)
        {
            if(g[gindex]<=s[sindex])//如果当前的饼干可以满足最贪心的小朋友,那么考虑下一块饼干是否可以满足下一位贪心的小朋友
            {
                result++;
                gindex--;
                sindex--;
            }
            else
            {
                gindex--;//否则直接忽略该小朋友
            }
        }
        return result;
    }
}
