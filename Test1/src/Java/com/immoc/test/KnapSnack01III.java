package com.immoc.test;

import java.util.logging.Level;

/**0-1背包问题的空间优化
 * Created by 18362 on 2017/11/7.
 */
public class KnapSnack01III {
    public int KnapSnack01(int []w,int []v,int c)
    {
        if(w.length<=0||c<=0)
            return 0;
        int memo[][]=new int[2][c+1];//只用两行数据来描述,大大节省了所用的空间
        for(int i=0;i<=c;i++)
            memo[0][i]=c>=w[0]?v[0]:0;//首行数据的初始化
        for(int i=1;i<w.length;i++)
        {
            for(int j=0;j<=c;j++)
            {
                memo[i%2][j]=memo[(i-1)%2][j];
                if(c>=w[i])
                    memo[i%2][j]=Math.max(memo[i%2][j],memo[(i-1)%2][j-w[i]]+v[i]);
            }
        }
        return memo[(w.length-1)%2][c];
    }
}
