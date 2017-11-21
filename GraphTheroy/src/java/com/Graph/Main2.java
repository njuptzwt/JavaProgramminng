package com.Graph;

/**
 * Created by 18362 on 2017/11/21.
 */
public class Main2 {
    public static void main(String[] args) {

        // TestG1.txt
        String filename1 = "D:\\test1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Component component1 = new Component(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.getCount());
        System.out.println();

        // TestG2.txt
        String filename2 = "D:\\test2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Component component2 = new Component(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.getCount());
    }
}
