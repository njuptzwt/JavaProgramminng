package com.union;

/**路径压缩找到并查集的连通与否！
 * 每次路径压缩的目的是为了把树的高度降低！
 * Created by 18362 on 2017/11/23.
 */
public class QuickUnion4 {
    private int[] parent; // parent[i]表示第一个元素所指向的父节点
    private int[] rank;     // sz[i]表示以i为根的集合中元素个数
    private int count;    // 数据个数

    // 构造函数
    public QuickUnion4(int count){
        parent = new int[count];
        rank = new int[count];
        this.count = count;
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for( int i = 0 ; i < count ; i ++ ){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    int find(int p){
        assert( p >= 0 && p < count );
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
//        while( p != parent[p] ) {
//            parent[p]=parent[parent[p]];//路径压缩的思路！大名鼎鼎
//            p = parent[p];
//        }
//        return p;
        //最强的路径压缩使用递归的思想，每次把节点递归到根节点，最优
        if(p!=parent[p])
        {
            parent[p]=find(p);
        }
        return parent[p];
    }
    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    void unionElements(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot )
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if( rank[pRoot] < rank[qRoot] ){
            parent[pRoot] = qRoot;
        }
        else{
            parent[qRoot] = pRoot;
            rank[pRoot]=Math.max(rank[pRoot],rank[qRoot]+1);//rank的优化
        }
    }
}
