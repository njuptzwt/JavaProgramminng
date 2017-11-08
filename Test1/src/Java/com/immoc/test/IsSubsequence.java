package com.immoc.test;

/**判断是否是子序列
 * 贪心算法求解！！子序列
 * Created by 18362 on 2017/11/8.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
    char []tarray=t.toCharArray();
    char []sarray=s.toCharArray();
    int tindex=0;
    int sindex=0;
    while(tindex<tarray.length&&sindex<sarray.length)
    {
        if(tarray[tindex]==sarray[sindex])
        {
            sindex++;
        }
        tindex++;
    }
    if(sindex==sarray.length)
        return true;
    else
        return false;
    }
}
