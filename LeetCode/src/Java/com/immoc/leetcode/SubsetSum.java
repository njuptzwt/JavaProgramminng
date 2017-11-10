package com.immoc.leetcode;

/**partion subset sum(很好的思路）
 * 比典型的0-1背包问题简单，只需要把包填满就可以了。
 * 使用0-1背包的方式计算
 * 使用一行数据表格代表全部的情况
 * Created by 18362 on 2017/11/7.
 */
public class SubsetSum {
    public static Boolean KnapSnack(int []w,int c)
    {
        if(w.length<=0)
            return false;
        if(c==0)
            return true;
        Boolean memo[]=new Boolean[c+1];
        memo[0]=true;//不需要填充0的背包，返回true
        for(int i=1;i<=c;i++)
            memo[i]=i==w[0]?true:false;//初始化第一行的数据
        for(int i=1;i<w.length;i++)
            for(int j=c;j>=w[i];j--)
                memo[j]=memo[j]||memo[j-w[i]];
        return memo[c];
    }
    public Boolean canPartion(int []w)
    {
        int sum=0;
        if(w.length<=1)
            return false;
        for(int i=0;i<w.length;i++)
            sum+=w[i];
        if(sum%2==1)
            return false;
        else
            return KnapSnack(w,sum/2);
    }
}
