package garen.demo.tree;

import java.util.Objects;

/**
 * @Title : 二叉树的结点类
 * @Description : 结点包括数据域存储结点数据 指针域分别指向左孩子结点和右孩子结点
 * @Author : Garen
 * @Date : 2019/11/6 22:50
 */
public class Node<E> {
    
    private E data;
    private Node<E> lchild;
    private Node<E> rchild;
    private boolean isFirst = false;
    
    /**
     * @description 默认构造方法
     */
    public Node() {
    }
    
    /**
     * @param data
     * @description 构造新结点
     */
    public Node(E data) {
        this.data = data;
    }
    
    public E getData() {
        return data;
    }
    
    public void setData(E data) {
        this.data = data;
    }
    
    public Node<E> getLchild() {
        return lchild;
    }
    
    public Node<E> getRchild() {
        return rchild;
    }
    
    public void setLchild(Node<E> lchild) {
        this.lchild = lchild;
    }
    
    public void setRchild(Node<E> rchild) {
        this.rchild = rchild;
    }
    
    public boolean isFirst() {
        return isFirst;
    }
    
    public void setFirst(boolean first) {
        isFirst = first;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node<E> temp = (Node<E>) obj;
            return this.data.equals(temp.data);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return data == null ? null : data.toString();
    }
}
