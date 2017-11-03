package com.immoc.test;

/**
 * 有阻塞情况下的网格走法,一样的递归，条件变了
 * Created by 18362 on 2017/11/3.
 */
public class UniquePathTwo {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]result=new int[m][n];
        for(int i=0;i<m;i++)
        {
            if(obstacleGrid[i][0]==1)
            {
                for(int j=i;j<m;j++)
                    obstacleGrid[j][0]=1;
                break;
            }
            result[i][0]=1;
        }
        for(int i=0;i<n;i++)
        {
            if(obstacleGrid[0][i]==1)
            {
                for(int j=i;j<n;j++)
                    obstacleGrid[0][j]=1;
                break;
            }
            result[0][i]=1;
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                if(obstacleGrid[i][j]==1)
                    result[i][j]=0;
                else
                    result[i][j]=result[i-1][j]+result[i][j-1];
        return result[m-1][n-1];
    }
    public static void main(String args[])
    {
        int [][]a=new int[3][3];
        a[1][1]=1;
        a[1][2]=1;
        System.out.println(uniquePathsWithObstacles(a));
    }
}
