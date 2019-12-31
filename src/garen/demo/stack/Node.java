package garen.demo.stack;
/**
 * @Title : 结点类
 * @Author : Garen
 * @Date : 2019/10/17 21:02
 */
public class Node<T> {
    Node<T> next;
    T data;

    /**
     * @description 构造新结点
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
