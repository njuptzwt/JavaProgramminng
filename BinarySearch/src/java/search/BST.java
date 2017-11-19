package search;

import java.util.LinkedList;

/**
 * 二叉搜索树的基本数据结构的构造
 * Created by 18362 on 2017/11/17.
 */
public class BST<Key extends Comparable, Value extends Comparable> {
    //树节点的构造
    class Node {
        private Key key;//按照键值排序
        private Value value;//value的值
        private Node leftnode;//左孩子
        private Node rightnode;//右孩子

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.leftnode = this.rightnode = null;
        }

        //这个构造函数可以起到复制的作用，在非递归的写法中需要用到该方法！！复制根节点的值
        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.leftnode = node.leftnode;
            this.rightnode = node.rightnode;
        }
    }

    public BST() {
        root = null;
        count = 0;
    }

    private Node root;//记录树的根节点
    private int count;//记录节点的数据量

    public int size() {
        return count;
    }

    public Boolean IsEmpty() {
        return count == 0;
    }

    //二叉搜索树的节点的插入，递归函数的使用方式,返回插入新的树节点之后的二叉树的根节点root！递归调用，明白了！
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    //根节点永远不会变化
    private Node insert(Node root, Key key, Value value) {
        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(root.key) == 0) {
            root.value = value;
        } else if (key.compareTo(root.key) < 0)
            root.leftnode = insert(root.leftnode, key, value);
        else
            root.rightnode = insert(root.rightnode, key, value);
        return root;
    }

    //二叉搜索树的迭代实现,根节点一直在变化？？
    public void insert2(Key key, Value value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        Node node = root;
        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                node.value = value;
                return;
            } else if (key.compareTo(node.key) > 0) {
                if (node.rightnode == null) {
                    node.rightnode = new Node(key, value);
                    return;
                }
                node = node.rightnode;
            } else {
                if (node.leftnode == null) {
                    node.leftnode = new Node(key, value);
                    return;
                }
                node = node.leftnode;
            }
        }
    }

    //contains函数的实现，是否包含某一个键值
    public Boolean contains(Node root, Key key) {
        if (root == null)
            return false;//递归的出口
        if (key.compareTo(root.key) == 0)
            return true;
        else if (key.compareTo((root.key)) > 0)
            return contains(root.rightnode, key);
        else
            return contains(root.leftnode, key);
    }

    //二叉搜索的函数
    public Value search(Node root, Key key) {
        if (root == null)
            return null;
        if (key.compareTo(root.key) == 0)
            return root.value;
        else if (key.compareTo(root.key) > 0)
            return search(root.rightnode, key);
        else
            return search(root.leftnode, key);
    }

    /**
     * 前序遍历，中序遍历，后序遍历实质上属于深度优先遍历算法！
     *
     * @param node
     */
    //二叉树的前序遍历，对以node为根的二叉树进行前序遍历,先访问中间节点，在访问左节点，最后访问右节点
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.leftnode);
            preOrder(node.rightnode);
        }
    }

    //二叉树的中序遍历，对以node为节点的二叉树进行中序遍历，先访问左节点，后访问中间节点，再访问右节点
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftnode);
            System.out.println(node.value);
            inOrder((node.rightnode));
        }
    }

    //二叉树的后序遍历，先左后右，最后再中间.对以node为根节点的二叉树进行后序遍历！
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftnode);
            postOrder(node.rightnode);
            System.out.println(node.value);
        }
    }

    /**
     * 层次遍历搜索算法，广度优先搜索算法！！需要借助额外的队列数据结构来实现
     * java中实现队列queue可以使用LinkedList，它实现了Queue的接口，实现按队列的基本操作
     */
    public void level() {
        LinkedList<Node> linkedList = new LinkedList<>();//队列存储数据
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            /**
             * 循环的将子节点入栈，同时将数据一直出栈，获取想要得到的值
             */
            Node res = linkedList.remove();//队头元素出队
            System.out.println(res.value);
            if (res.leftnode != null)
                linkedList.add(res.leftnode);
            if (res.rightnode != null)
                linkedList.add(res.rightnode);
        }
    }

    //删除操作，从删除二叉树的最大值和最小值开始
    public Key Minimum() {
        assert count > 0;
        Node node = Minimum(root);
        return node.key;
    }

    //返回以node为根节点的二叉树的最小值节点的递归写法
    private Node Minimum(Node node) {
        if (node.leftnode != null) {
            return Minimum(node.leftnode);
        } else
            return node;
    }

    //非递归函数的写法
    private Node Minimum2(Node node) {
        Node temp = new Node(node);
        while (temp.leftnode != null) {
            temp = new Node(temp.leftnode);
        }
        return temp;
    }

    //删除最大值的操作，首先要找到最大值
    public Key Maximum() {
        assert count > 0;
        Node node = Maximum(root);
        return node.key;
    }

    //返回以node为节点的二叉树的最大值节点
    private Node Maximum(Node node) {
        if (node.rightnode != null)
            return Maximum(node.rightnode);
        else
            return node;
    }

    //删除二叉树中最小值节点的函数
    public void removeMin() {
        assert count > 0;
        root = removeMin(root);
    }

    //递归的删除二叉树的函数,返回删除后的二叉树的新节点
    private Node removeMin(Node node) {
        if (node.leftnode != null)
            node.leftnode = removeMin(node.leftnode);
        else {
            node = node.rightnode;
            count--;
        }
        return node;
    }

    //使用非递归的方式删除最大节点,注意java的传值方式，引用指向不同的地址处!!!!好用！！
    private void removeMin2(Node node) {
        while (node.leftnode != null) {
            node = node.leftnode;
        }
        node = node.rightnode;
        count--;
    }

    public void removeMax() {
        assert count > 0;
        root = removeMax(root);
    }

    //定义：返回删除以Node为根节点的树删除最大节点后二叉树的根
    private Node removeMax(Node node) {
        if (node.rightnode != null)
            node.rightnode = removeMax(node.rightnode);
        else {
            node = node.leftnode;
            count--;//节点的数据减少一个
        }
        return node;
    }

    //使用迭代的方式删除最大的节点,使用迭代方式也是很容易理解的！！
    private void removeMax2(Node node) {
        while (node.rightnode != null) {
            node = node.rightnode;
        }
        node = node.leftnode;
        count--;
    }

    //删除任意节点的递归和非递归的方式！！
    public void remove(Key key) {
        assert count > 0;
        root = remove(root, key);
    }

    //删除二叉树中以node节点为根的任意键值的元素，返回删除以后二叉树的根；思路和实现
    private Node remove(Node node, Key key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.leftnode = remove(node.leftnode, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.rightnode = remove(node.rightnode, key);
            return node;
        } else {
            if (node.leftnode == null) {
                count--;
                return node.rightnode;
            } else if (node.rightnode == null) {
                count--;
                return node.leftnode;
            } else {
                //删除的节点有两个子树
                Node temp = new Node(Minimum(node.rightnode));
                temp.rightnode = removeMin(node.rightnode);
                temp.leftnode = node.leftnode;
                node.leftnode =node.rightnode= null;//空间回收？多余的操作吧。
                return temp;
            }
        }
    }
    //找一个数据的前驱，左子树中的最大值
    private Node pressor(Key key)
    {
        if(root==null)
            return null;
        Node node=root;
        while(key.compareTo(node.key)!=0)
        {
            if(key.compareTo(node.key)>0)
                node=node.rightnode;
            else
                node=node.leftnode;
        }
        node=Maximum(node.leftnode);
        return node;
    }
    //找一个数的后继，右子树中的最小值
    private Node successor(Key key)
    {
        if(root==null)
            return null;
        Node node=root;
        while(key.compareTo(node.key)!=0)
        {
            if(key.compareTo(node.key)>0)
                node=node.rightnode;
            else
                node=node.leftnode;
        }
        node=Minimum(node.rightnode);
        return node;
    }
    public static void main(String[] args) {
        Integer arr[] = {45, 12, 34, 23, 41, 56, 47, 67, 87, 90};
        BST<Integer, String> bst = new BST();
        for (int i = 0; i < 10; i++) {
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));
        }


//        int N = 1000000;
//
//        // 创建一个数组，包含[0...N)的所有元素
//        Integer[] arr = new Integer[N];
//        for(int i = 0 ; i < N ; i ++)
//            arr[i] = new Integer(i);
//
//        // 打乱数组顺序
//        for(int i = 0 ; i < N ; i ++){
//            int pos = (int) (Math.random() * (i+1));
//            Integer t = arr[pos];
//            arr[pos] = arr[i];
//            arr[i] = arr[pos];
//        }
//        // 由于我们实现的二分搜索树不是平衡二叉树，
//        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
//        // 平衡二叉树的实现，我们在这个课程中没有涉及，
//        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
//        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）
//
//
//        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
//        // 键值的对应关系为每个整型对应代表这个整型的字符串
//        BST<Integer,String> bst = new BST<Integer,String>();
//        for(int i = 0 ; i < N ; i ++)
//            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));
//
//        // 对[0...2*N)的所有整型测试在二分搜索树中查找
//        // 若i在[0...N)之间，则能查找到整型所对应的字符串
//        // 若i在[N...2*N)之间，则结果为null
//        for(int i = 0 ; i < 2*N ; i ++){
//            String res = bst.search(bst.root,new Integer(i));
//            if( i < N )
//                assert res == Integer.toString(i);
//            else
//                assert res == null;
//        }
    }
}

