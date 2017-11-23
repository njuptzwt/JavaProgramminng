package com.union;

/**
 * Created by 18362 on 2017/11/23.
 */
public class QuickUnion {
    private int parent[];
    int count;
    public QuickUnion(int count)
    {
        this.count=count;
        parent=new int[count];
        for(int i=0;i<count;i++)
            parent[i]=i;//初始每一个节点的父亲节点都指向的是自己
    }
    //考察p节点属于那一块区域，是由那一颗树派生出来的。找同组元素
    public int find(int p)
    {
        while(parent[p]!=p)
        {
            p=parent[p];
        }
        return p;
    }
    public boolean isConnected(int a,int b)
    {
        return find(a)==find(b);
    }
    public void UnionElements(int a,int b)
    {
        if(find(a)==find(b))
            return ;
        parent[a]=find(b);
        return ;
    }
}
