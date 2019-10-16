package garen.demo.Linkedlist;

public class Node<T>{
    T data;
    Node<T> next;

    /**
     * @description 构造一个新的结点
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

