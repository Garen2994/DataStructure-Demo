package garen.demo.Tree;

import java.util.LinkedList;

/**
 * @Title : 二叉树的构建及相关操作
 * @Description :
 * @Author : Garen
 * @Date : 2019/11/6 22:56
 */
public class BinaryTree<E> {
    private Node<E> root;

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }
    /**
     * @description 无参构造函数
     */
    public BinaryTree() {
        super();
    }

    /**
     * @param exp
     * @description 根据广义表表达式建立二叉树 借助栈
     */
//    public void createBinaryTree(String exp) {  //String exp为广义表表达式
//        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); //建立结点类型的栈
//        Node<E> node = null;   //新结点
//        Node<E> parent = null;    //父结点
//        Node<E> temp = null;   //用于入栈
//    }


}

