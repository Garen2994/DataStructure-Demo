package garen.demo.Tree;

import java.util.LinkedList;

/**
 * @Title : 二叉树(非线性结构)的构建与相关操作
 * @Description :
 * - 以广义表形式的字符串构建二叉树：'()'前表示根结点，括号中左右子树用逗号隔开，逗号不能省略
 * - 二叉树的层次/广序遍历算法
 * - 二叉树的前序、中序、后序遍历的递归和非递归算法(对每个节点而言，三种遍历方式都需要遍历该结点三次，三者唯一区别在于该结点的访问时机)
 * - 根据二叉树的前序、中序或中序、后序遍历结果构建二叉树
 * - 二叉树的高度
 * - 二叉树的结点总数
 * - 根据树的根结点复制一颗二叉树
 * - 获取二叉树的根结点，孩子节点
 * - 打印二叉树
 * - 判断两颗二叉树是否相等
 * @Author : Garen
 * @Date : 2019/12/23 15:57
 */
@SuppressWarnings("unchecked")
public class BinaryTree<E> {
    private Node<E> root;   //二叉树根结点

    /**
     * @param
     * @description 无参构造函数
     */

    public BinaryTree() {
        super();
    }

    /**
     * @param root
     * @description 以根节点为参数的构造方法
     */
    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    /**
     * @param exp
     * @description 根据广义表表达式建立二叉树 借助栈
     */
    public Node<E> createBinaryTree(String exp) {  //String exp为广义表表达式
        LinkedList<Node<E>> stack = new LinkedList<>();
        Node<E> node = null;
        Node<E> parent = null;
        Node<E> temp = null;
        boolean flag = false; //true 左孩子  false 右孩子

        System.out.println("广义表表达式为:" + exp);
        if (exp.length() == 0 || exp.isEmpty()) {
            return null;
        }
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '(':
                    stack.push(temp);
                    flag = true;
                    break;
                case ')':
                    stack.pop();
                    break;
                case ',':
                    flag = false;
                    break;
                default:
                    node = new Node(c);
                    break;
            }
            if (root == null)
                root = node;   //第一个读入的结点为根节点
            if (!stack.isEmpty()) {   //栈不为空
                if (node != null) {
                    parent = stack.peek();   //栈顶元素作为父结点
                    if (flag)   //以父结点为根 链入孩子结点
                        parent.setLchild(node);
                    else
                        parent.setRchild(node);
                }

            }
            temp = node; //将非空的结点准备压入栈中
            node = null;
        }
        return root;
    }


    /**
     * @param root
     * @description 先序递归遍历
     */
    public void preOrderTraverse(Node<E> root) {
        if (root == null)
            return;
        System.out.print(root.getData() + "\t");
        preOrderTraverse(root.getLchild());
        preOrderTraverse(root.getRchild());
    }

    /**
     * @param root
     * @description 前序遍历非递归 (迭代)---利用栈
     */
    public void preOrder(Node<E> root) {
        if (root == null)
            return;
        LinkedList<Node> stack = new LinkedList<>();   //栈用来存访问但未输出的结点
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.getData() + "\t");
                stack.push(node);
                node = node.getLchild();
            } else {
                node = stack.pop();
                node = node.getRchild();
            }
        }
    }


    /**
     * @param root
     * @description 中序递归遍历
     */
    public void inOrderTraverse(Node<E> root) {
        if (root == null)
            return;
        inOrderTraverse(root.getLchild());
        System.out.print(root.getData() + "\t");
        inOrderTraverse(root.getRchild());
    }

    public void inOrder(Node<E> root) {
        if (root == null)
            return;
        LinkedList<Node> stack = new LinkedList<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLchild();
            } else {
                node = stack.pop();
                System.out.print(node.getData() + "\t");
                node = node.getRchild();
            }
        }
    }

    /**
     * @param root
     * @description 后序递归遍历
     */
    public void postOrderTraverse(Node<E> root) {

        if (root == null)
            return;
        postOrderTraverse(root.getLchild());
        postOrderTraverse(root.getRchild());
        System.out.print(root.getData() + "\t");
    }

    public void postOrder(Node<E> root) {
        if (root == null)
            return;
        LinkedList<Node<E>> stack = new LinkedList<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                node.setFirst(true);  //首次访问该节点，记为true
                stack.push(node);
                node = node.getLchild();
            } else {
                node = stack.pop();
                if (node.isFirst()) {
                    node.setFirst(false);  //第二次访问该节点，改为false
                    stack.push(node);    //只有在第三次才访问，因此，前结点再次压栈
                    node = node.getRchild();
                }else{
                    System.out.print(node.getData()+"\t");
                    node = null;
                }
            }
        }
    }
}

