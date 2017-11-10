package com.immoc.leetcode;

/**0-1背包问题的空间复杂度为O(1)只有一行的表格需要保存
 * Created by 18362 on 2017/11/7.
 */
public class KnapSnack01IV {
    public int KnapSnack01(int[]w,int[]v,int c)
    {
        if(w.length<=0||c<=0)
            return 0;
        int[] memo=new int[c+1];
        for(int i=0;i<=c;i++)
            memo[i]=c>=w[0]?v[0]:0;
        for(int i=1;i<=w.length;i++)
        for(int j=c;j>=0;j--)
            if(j>=w[i])
                memo[j]=Math.max(memo[j],memo[j-w[i]]+v[i]);
        return memo[c];
    }
}
