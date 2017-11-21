package com.Graph;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**广度优先搜索算法，记录最短的路径
 * 并且可以计算出每个节点到相应节点的最短路径
 * Created by 18362 on 2017/11/21.
 */
public class ShortestPath {
    private int s;
    private boolean []visited;
    private int []from;
    private int ordered[];
    private Graph graph;
    //最短路径的构造函数，无向图
    public ShortestPath(Graph graph,int s)
    {
        this.graph=graph;
        this.s=s;
        visited=new boolean[graph.V()];//记录是否访问过该节点
        ordered=new int[graph.V()];//记录最短长度
        from=new int[graph.V()];//记录源头
        for(int i=0;i<graph.V();i++)
        {
            visited[i]=false;
            from[i]=-1;
            ordered[i]=-1;
        }
        //广度优先遍历的思想
        LinkedList<Integer> list=new LinkedList<>();//作为队列使用，先进先出
        list.push(s);
        visited[s]=true;
        ordered[s]=0;
        //借助队列实现的广度优先搜索的算法
        while(!list.isEmpty())
        {
            int temp=list.pop();
            for(Integer i:graph.adj(temp))
            {
                if(!visited[i])
                {
                    ordered[i]=ordered[temp]+1;
                    visited[i]=true;
                    from[i]=temp;
                    list.push(i);
                }
            }
        }
    }
    public boolean hasPath(int w)
    {
        assert w>=0&&w<graph.V();
        return visited[w];
    }
    public Vector<Integer> shortestPath(int w)
    {
        Stack<Integer> stack=new Stack<>();
        Vector<Integer> vector=new Vector<>();
        int p=w;
        while(p!=-1)
        {
            stack.push(p);//栈，先进后出的内容
            p=from[p];
        }
        while(!stack.isEmpty())
        {
            vector.add(stack.pop());
        }
        return vector;
    }
    public void showPath(int w)
    {
        assert hasPath(w) ;
        Vector<Integer> vec = shortestPath(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
    public int getOrder(int w)
    {
        return ordered[w];
    }
}

