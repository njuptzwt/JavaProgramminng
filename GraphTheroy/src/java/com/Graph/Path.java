package com.Graph;

import org.omg.CORBA.portable.ValueInputStream;

import java.util.Stack;
import java.util.Vector;

/**
 * 图论获取
 * Created by 18362 on 2017/11/21.
 */
public class Path {
    private int s;//源节点
    private Graph graph;
    private boolean[] visited;
    private int[] from;//记录每一元素是从哪里来的

    //寻找从s节点（源节点）到其他节点的路径
    public Path(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        visited=new boolean[graph.V()];
        from=new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;//初始化的操作
        }
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for (Integer temp : graph.adj(v))
            if (!visited[temp]) {
                from[temp] = v;
                dfs(temp);
            }
    }

    public Vector<Integer> getPath(int w) {
        assert hasPath(w);
        Stack<Integer> stack = new Stack<>();
        int p = w;
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<>();
        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        while (!stack.empty()) {
            int temp = stack.pop();
            res.add(temp);
        }
        return res;
    }

    public void showPath(int w) {
        assert hasPath(w);
        Vector<Integer> vec = getPath(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    public boolean hasPath(int w) {
        assert w >= 0 && w < graph.V();
        return visited[w];
    }
}
