package com.immoc.test;

/**注意题目的意思，小偷是沿着街偷（不走回头路）
 * 动态规划的子问题的解，大问题的解
 * Created by 18362 on 2017/11/3.
 */
public class HouseRobber {
    private static int[]result;
    //状态所需要求的东西，状态转移方程阐述怎么求
    public int rob(int[] nums) {
        int length=nums.length;
        if(length==0)
            return 0;
        result=new int[length];
        result[length-1]=nums[length-1];//初始偷取最后一件房子
        result[length-2]=nums[length-2];//偷倒数第二个房子
        for(int i=length-3;i>=0;i--)
            for(int j=i;j<length;j++)
                result[i]=Math.max(result[i],nums[j]+(j<length-2?result[j+2]:0));//状态的转移方程
        return result[0];
    }
}
