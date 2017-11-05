package com.immoc.test;

/**小偷抢劫一条街道，典型的0-1背包问题
 * 每家每户的请的数量价值只有一种，方案，偷或者不偷
 * f(n)定义为偷取前n+1的房子能偷到的最大价值f(n)=max(f(n-1),f(n-2)+v[n])
 * Created by 18362 on 2017/11/4.
 */
public class HouseRobberPackage {
    public int rob(int[] nums) {
        int length=nums.length;
        if(length==0)
            return 0;
        int []result=new int[length];
        result[0]=nums[0];
        for(int i=1;i<length;i++)//状态转移的方程
            result[i]=Math.max(result[i-1],i-2>=0?result[i-2]+nums[i]:nums[i]);
        return result[length-1];

    }
}
