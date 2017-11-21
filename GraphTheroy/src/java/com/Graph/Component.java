package com.Graph;


/**统计一个图中有多少的连通分量
 * Created by 18362 on 2017/11/21.
 */
public class Component {
    private Graph graph;
    private boolean[] visited;
    private int count;//连通分量的个数
    private int []id;//节点属于哪一个连通的分量，两个点之间是否连接起来了
    public Component(Graph graph)
    {
        this.graph=graph;
        visited=new boolean[graph.V()];//记录每一个点是否访问过
        id=new int[graph.V()];
        this.count=0;
        for(int i=0;i<graph.V();i++) {
            visited[i] = false;//初始全部没有被访问过
            id[i]=-1;
        }
        for(int i=0;i<graph.V();i++ )
        {
            if(!visited[i])
            {
                dfs(i);//深度优先遍历，每次都从一条路走到底，递归的思想，走不通往回走！回溯法的思想
                count++;
            }
        }
    }
    private void dfs(int v)
    {
        visited[v]=true;
        id[v]=count;
       for(Integer it:graph.adj(v))
           if(!visited[it])
               dfs(it);
    }
    public int  getCount()
    {
        return count;
    }
    public boolean connect(int v,int w)
    {
        assert v>=0&&v<graph.V();
        assert w>=0&&w<graph.V();
        return id[v]==id[w];
    }

}
