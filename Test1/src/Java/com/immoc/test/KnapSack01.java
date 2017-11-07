package com.immoc.test;

/**0-1背包问题
 * 递归方式求解
 * 经典的问题：背包的容量是C,物品的重量数组依次是W[i]，物品的价值分别是v[i]
 * 求最大的价值问题,假设下标为n前的所有物品装入C容量的背包的最大价值
 * f(n,c)=max(f(n-1,c),f(n-1,c-w[i]+v[i])
 * Created by 18362 on 2017/11/6.
 */
public class KnapSack01 {
    private int [][]memo;//递归函数中的记忆化数组

    /**
     * 0-1背包中的状态转移方程
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    public int BestValue(int []w, int []v, int index, int c)
    {
        if(index<0||c<=0)
            return 0;
        if(memo[index][c]!=-1)
            return memo[index][c];//记忆化数组
        int res=BestValue(w,v,index-1,c);//不加当前的物品
        if(c>=w[index])
        {
            res=Math.max(res,w[index]+BestValue(w,v,index-1,c-w[index]));
        }
        memo[index][c]=res;
        return res;
    }
    /**
     * 背包数组的获取的最大值
     */
    public int knapsack(int []w,int []v,int c)
    {
        int length=w.length;
        if(length<=0||c<=0)
            return 0;
        memo=new int[length-1][c+1];
        for(int i=0;i<length;i++)
            for(int j=0;j<=c;j++)
                memo[i][j]=-1;//初始化记忆化数组
        return BestValue(w,v,length,c);
    }
}
