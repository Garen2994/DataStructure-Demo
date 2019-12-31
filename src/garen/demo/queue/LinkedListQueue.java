package garen.demo.queue;

/**
 * @Title : 队列的三种实现方法之一 --- 基于链表的队列实现
 * @Description : 链式队列
 * @Author : Garen
 * @Date : 2019/10/23 21:38
 */
public class LinkedListQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    /**
     * @description 初始化链式队列
     */
    public LinkedListQueue() {
        front = new Node<E>(null);
        rear = front;
    }

    public void add(E data) {
        Node<E> node = new Node<E>(data);
        rear.next = node;
        rear = node;
        size++;
    }

    public E remove() {
        if (!isEmpty()) {
            E e = null;
            Node<E> node = new Node<E>(null);
            node = front.next;
            front.next = node.next;
            e = node.data;

            //释放node结点
            node.data = null;
            node.next = null;
            size--;

            return e;
        }
        return null;
    }

    public E peek() {
        if (!isEmpty()) {
            return front.next.data;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node<E> cur = front.next;
        StringBuilder sb = new StringBuilder(); //泛型的读
        while(cur != null){
            sb.append(cur.data).append("->");
            cur = cur.next;
        }
        sb.append("^");
        return sb.toString();
    }
}