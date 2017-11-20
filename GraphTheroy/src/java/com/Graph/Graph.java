package com.Graph;

/**
 * Created by 18362 on 2017/11/20.
 */
public interface Graph {
    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}
