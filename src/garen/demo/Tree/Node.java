package garen.demo.Tree;

/**
 * @Title : 二叉树的结点类
 * @Description : 结点包括数据域存储结点数据 指针域分别指向左孩子结点和右孩子结点
 * @Author : Garen
 * @Date : 2019/11/6 22:50
 */
public class Node<T> {

    T data;
    Node<T> lchild;
    Node<T> rchild;
//    boolean isFirst;

    /**
     * @description 构造新结点
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> lchild, Node<T> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public void setLchild(Node<T> lchild) {
        this.lchild = lchild;
    }
    public void setRchild(Node<T> rchild) {
        this.rchild = rchild;
    }
    //前序遍历（递归）
    public void frontShow() {
        //遍历当前内容
        System.out.print("\t"+data);
        //左节点
        if(lchild!=null) {
            lchild.frontShow();
        }
        //右节点
        if(rchild!=null) {
            rchild.frontShow();
        }
    }
    //中序遍历
    public void midShow()
    {
        //左节点
        if(lchild!=null) {
            lchild.midShow();
        }
        //遍历当前内容
        System.out.print("\t"+data);
        //右节点
        if(rchild!=null) {
            rchild.midShow();
        }
    }
    public void afterShow() {
        //左节点
        if(lchild!=null) {
            lchild.midShow();
        }
        //右节点
        if(rchild!=null) {
            rchild.midShow();
        }
        //遍历当前内容
        System.out.print("\t"+data);

    }
    @Override
    public String toString() {
        return data == null ?null : data.toString();
    }
}
