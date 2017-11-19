import java.util.LinkedList;

/**
 * Created by 18362 on 2017/11/19.
 */
// 二分搜索树
// 由于Key需要能够进行比较，所以需要extends Comparable<Key>
public class BST<Key extends Comparable<Key>, Value> {

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;//记录以该节点为节点的数据的结点个数

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
            this.size = node.size;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    // 构造函数, 默认构造一棵空二分搜索树
    public BST() {
        root = null;
        count = 0;
    }

    // 返回二分搜索树的节点个数
    public int size() {
        return count;
    }

    // 返回二分搜索树是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 向二分搜索树中插入一个新的(key, value)数据对
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    // 查看二分搜索树中是否存在键key
    public boolean contain(Key key) {
        return contain(root, key);
    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key) {
        return search(root, key);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {

        // 我们使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {

            Node node = q.remove();

            System.out.println(node.key);

            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
    }

    // 寻找二分搜索树的最小的键值
    public Key minimum() {
        assert count != 0;
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 寻找二分搜索树的最大的键值
    public Key maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 从二分搜索树中删除最小值所在节点
    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    // 从二分搜索树中删除最大值所在节点
    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    // 从二分搜索树中删除键值为key的节点
    public void remove(Key key) {
        root = remove(root, key);
    }

    //********************
    //* 二分搜索树的辅助函数
    //********************

    // 向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
            node.size++;
        } else    // key > node->key
        {
            node.right = insert(node.right, key, value);
            node.size++;
        }

        return node;
    }

    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
    private boolean contain(Node node, Key key) {

        if (node == null)
            return false;

        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else // key > node->key
            return contain(node.right, key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node, Key key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node.value;
        else if (key.compareTo(node.key) < 0)
            return search(node.left, key);
        else // key > node->key
            return search(node.right, key);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    // 返回以node为根的二分搜索树的最小键值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {

            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        node.size--;//维护变量
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {

            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    Node remove(Node node, Key key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            node.size--;
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            node.size--;
            return node;
        } else {   // key == node->key

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right));
            successor.size = node.size - 1;
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count--;

            return successor;
        }
    }

    //打印每一个节点为根的子树的节点数目
    public void print(Node node) {
        if (node != null) {
            System.out.print(node.size + " ");
            print(node.left);
            print(node.right);
        }
    }

    //Rank()函数，该函数可以准确的找出给的Key值的排名,利用中间变量存储二叉树节点的个数得到！可以用递归实现
    public int Rank(Key key) {
        Node node = root;
        int index = 0;
        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                index++;
                if (node.left != null)
                    index += node.left.size;
                break;
            } else if (key.compareTo(node.key) < 0)
                node = node.left;
            else if (key.compareTo(node.key) > 0) {
                index++;
                if (node.left != null)
                    index += node.left.size;
                node = node.right;
            }
        }
        if (node == null)
            return -1;//没有符合条件的值
        return index;
    }
    //Select()函数,根据下标号来获取对应的node值
    public Value select(int index)
    {
        assert index>=1&&index<=count;
        Node node=root;
        while(node!=null)
        {
            if(node.left!=null) {
                if(node.left.size+1==index)
                {
                    break;
                }
                else if (node.left.size + 1 < index) {
                    index -= (node.left.size+1);
                    node = node.right;
                } else
                    node = node.left;
            }
            else
            {
              if(index==1)
                  break;
              else
              {
                  index--;
                  node=node.right;
              }
            }
        }
        return node.value;
    }
    // 测试二分搜索树
    public static void main(String[] args) {

        Integer[] arr = {10, 5, 7, 4, 9, 6, 2, 18, 15, 16, 19, 14, 13};
        BST<Integer, String> bst = new BST<Integer, String>();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));
        }
        System.out.println();
        System.out.println(bst.Rank(10));
        System.out.println(bst.select(1));
//            System.out.println();
//            bst.print(bst.root);
//            System.out.println();
//            bst.preOrder();
        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
//            for(int i = 0 ; i < 2*N ; i ++){
//                String res = bst.search(new Integer(i));
//                if( i < N )
//                    assert res == Integer.toString(i);
//                else
//                    assert res == null;
//            }
    }
}
