package com.Graph;


import java.util.Vector;

/**稠密图，使用邻接矩阵比较合适
 * 所谓的稠密图是指每一个节点连接的变都有很多
 * Created by 18362 on 2017/11/20.
 */
public class DenseGraph implements Graph {
    private int n;//节点的个数
    private int m;//边的个数
    private boolean[][] g;//邻接矩阵，存储相应的图和边
    private boolean directed;//是否有方向的图
    //初始化构造函数
    public DenseGraph(int n,boolean directed)
    {
        this.n=n;
        this.m=0;
        this.directed=directed;
        g=new boolean[n][n];
    }
    public int V()
    {
        return n;
    }
    public int E()
    {
        return m;
    }
    //构造两个节点之间的边
    public void addEdge(int v,int w)
    {
        assert v>=0&&v<n;
        assert w>=0&&w<n;
        if(hasEdge(v,w))
            return ;//只允许加载一次
        g[v][w]=true;
        if(!directed)
            g[w][v]=true;//
        m++;//边加1
    }
    public boolean hasEdge(int v,int w)
    {
        assert v>=0&&v<n;
        assert w>=0&&w<n;
        return g[v][w];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    //返回节点v的临边
    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v)
    {
        assert v>=0&&v<n;
        Vector<Integer> vector=new Vector<>();
        for(int i=0;i<n;i++)
            if(g[v][i])
                vector.add(i);
        return vector;
    }
}
