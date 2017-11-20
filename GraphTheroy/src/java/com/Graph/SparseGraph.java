package com.Graph;

import com.Graph.Graph;

import java.util.Vector;

/**稀疏图，使用邻接表的形式
 * Created by 18362 on 2017/11/20.
 */
public class SparseGraph implements Graph {
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer> []g;//存储邻接表，变长的形式

    public SparseGraph(int n,boolean directed)
    {
        this.n=n;
        this.m=0;
        this.directed=directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g=(Vector<Integer>[])new Vector[n];
        for(int i=0;i<n;i++)
            g[i]=new Vector<>();
    }
    public int E()
    {
        return m;
    }
    public int V()
    {
        return n;
    }
    public void addEdge(int v,int w)
    {
        assert v>=0&&v<n;
        assert w>=0&&w<n;
//        if(hasEdge(v,w))
//            return;//邻接表的缺点，判断是否有平行边的时候要花费更大的时间力量
        g[v].add(w);
        if(v!=w&&!directed)
            g[w].add(v);
        m++;//边数加一
    }
    public boolean hasEdge(int v,int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v].contains(w);
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

    //找到v的相邻节点，边，并且将相邻节点
    // 存入一个迭代器中（list(vector,arraylist,linnkedlist),map,set),简单点返回一个list就好了
    public Iterable<Integer> adj(int v)
    {
        assert v>=0&&v<n;
        return g[v];
    }
}
