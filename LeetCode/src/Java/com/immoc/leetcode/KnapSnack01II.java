package com.immoc.leetcode;

/**使用动态规划的解法解决0-1背包问题
 *
 * Created by 18362 on 2017/11/6.
 */
public class KnapSnack01II {
    public int Knapsnack(int []w,int v[],int c)
    {
        if(w.length<=0||c<=0)
            return 0;
        int [][]value=new int[w.length+1][c+1];//value[i][j]代表将前i个物品放进容量为j的书包中的最大价值
        for(int i=1;i<w.length+1;i++)
            for(int j=1;j<=c;j++)
            {
                if(j>=w[i-1])
                    value[i][j]=Math.max(value[i-1][j],value[i-1][j-w[i-1]]+v[i-1]);
                else
                    value[i][j]=value[i-1][j];
            }
            return value[w.length][c];
    }
}
