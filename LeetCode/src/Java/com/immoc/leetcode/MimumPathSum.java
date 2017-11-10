package com.immoc.leetcode;

/**
 * 给出一个m*n的矩阵，求从最上面的顶端开始，
 * Created by 18362 on 2017/11/2.
 */
public class MimumPathSum {
    public static int minPathSum(int[][] grid)
    {
        int m=grid.length;
        int n=grid[m-1].length;
        int [][]Mim=new int[m][n];
        if(m==1&&n==1)
            return grid[0][0];
        else
        {
            Mim[0][0]=grid[0][0];
            for(int i=1;i<n;i++)
                Mim[0][i]=grid[0][i]+Mim[0][i-1];
            for(int i=1;i<m;i++)
                Mim[i][0]=grid[i][0]+Mim[i-1][0];
            for(int i=1;i<m;i++)
                for(int j=1;j<n;j++)
                    Mim[i][j]= Math.min(Mim[i][j-1],Mim[i-1][j])+grid[i][j];
            return Mim[m-1][n-1];
        }
    }
}

