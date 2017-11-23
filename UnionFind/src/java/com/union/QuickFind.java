package com.union;


import javax.print.attribute.standard.DocumentName;

/**并查集，主要解决问题是回答图或者其他数据结构中的两个点是否连接的问题
 * 主要支持两个操作
 * 1、合并操作（同根）
 * 2、find操作，在哪一个组里
 * Created by 18362 on 2017/11/23.
 */
public class QuickFind {
    private int []id;
    private int count;
    public QuickFind(int count)
    {
        id=new int[count];
        this.count=count;
        //id初始化，每一个元素的初始都是跟自己连接，自己是根元素
        for(int i=0;i<this.count;i++)
        {
            id[i]=i;
        }
    }
    public  void Union(int a,int b)
    {

    }
    public  int find(int p)
    {
        assert p<count;
        return id[p];//返回根节点
    }
    public boolean isConnected(int a,int b)
    {
        assert a>=0&&a<count;
        assert b>=0&&b<count;
        return find(a)==find(b);
    }
    public void unionElements(int a,int b)
    {
        assert a>=0&&a<count;
        assert b>=0&&b<count;
        int index1=find(a);
        int index2=find(b);
        if(index1==index2)
            return;
        for(int i=0;i<count;i++)
            if(id[i]==index2)
                id[i]=index1;
        return ;
    }
}
