package search;

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
       root  = insert(root, key, value);
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
        Node node=root;
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
   public  Boolean contains(Node root,Key key)
   {
       if(root==null)
           return false;//递归的出口
       if(key.compareTo(root.key)==0)
           return true;
       else if(key.compareTo((root.key))>0)
           return contains(root.rightnode,key);
       else
           return contains(root.leftnode,key);
   }
   //二叉搜索的函数
    public Value search(Node root,Key key)
    {
        if(root==null)
            return null;
        if(key.compareTo(root.key)==0)
            return root.value;
        else if(key.compareTo(root.key)>0)
            return search(root.rightnode,key);
        else
            return search(root.leftnode,key);
    }
    //二叉树的前序遍历，对以node为根的二叉树进行前序遍历,先访问中间节点，在访问左节点，最后访问右节点
    public void preOrder(Node node)
    {
        if(node!=null)
        {
            System.out.println(node.value);
            preOrder(node.leftnode);
            preOrder(node.rightnode);
        }
    }
    //二叉树的中序遍历，对以node为节点的二叉树进行中序遍历，先访问左节点，后访问中间节点，再访问右节点
    public void midOrder(Node node)
    {
        if(node!=null)
        {
            midOrder(node.leftnode);
            System.out.println(node.value);
            midOrder((node.rightnode));
        }
    }
    //二叉树的后序遍历，先左后右，最后再中间.对以node为根节点的二叉树进行后序遍历！
    public void laOrder(Node node)
    {
        if(node!=null)
        {
            laOrder(node.leftnode);
            laOrder(node.rightnode);
            System.out.println(node.value);
        }
    }

}

