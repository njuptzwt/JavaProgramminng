package com.niuke;

import java.util.Scanner;

/**
 * Created by 18362 on 2017/11/20.
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    public TreeNode(){
        this.left=null;
        this.right=null;
    }
    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    public static int Height(TreeNode node)
    {
        if(node==null)
            return 0;
        return Math.max(Height(node.left),Height(node.right))+1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        TreeNode node[] = new TreeNode[count];
        for (int i = 0; i < count - 1; i++) {    //构造树的过程
            int p = sc.nextInt();
            if(node[p]==null)
                node[p]=new TreeNode();
            int q = sc.nextInt();
            if(node[q]==null)
                node[q]=new TreeNode();
            if (node[p].getLeft()== null)
                node[p].setLeft(node[q]);
            else
                node[p].setRight(node[q]);
        }
        int height=Height(node[0]);
        System.out.println(height);
    }
}