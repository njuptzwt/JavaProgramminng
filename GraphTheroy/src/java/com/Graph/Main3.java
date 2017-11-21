package com.Graph;

/**
 * Created by 18362 on 2017/11/21.
 */
public class Main3 {
    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "D:\\test3.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
