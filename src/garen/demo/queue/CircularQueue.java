package garen.demo.queue;

/**
 * @Title : 顺序存储结构实现循环队列 包含两个指针front和rear
 * @Description : 注意队列满条件和求队列长度
 * @Author : Garen
 * @Date : 2019/10/29 22:47
 */
public class CircularQueue<E> {
    private Object[] circularQueue;
    private int front;
    private int rear;
    private int maxSize;

    /**
     * @param maxSize
     * @description 初始化循环队列  建立maxSize长度的数组
     */
    public CircularQueue(int maxSize) {
        this.circularQueue = new Object[maxSize];
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
    }

    /**
     * @param data
     * @description 入队列操作
     */
    public void push(E data) {
        if (!isFull()) {
            circularQueue[rear] = data;   // data赋值给队尾
            rear = (rear + 1) % maxSize;  //rear向后移一位 (循环)
        } else
            throw new RuntimeException("队列已满!");
    }

    /**
     * @return
     * @description 出队列操作
     */
    @SuppressWarnings({"unchecked"})
    public E pop() {
        if (!isEmpty()) {
            E e = (E) circularQueue[front];  //当前队头元素赋值给e
            circularQueue[front] = null;
            front = (front + 1) % maxSize;   //front向后移一位
            return e;
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * @return
     * @description 返回队头元素
     */
    @SuppressWarnings({"unchecked"})
    public E peek() {
        if (!isEmpty()) {
//            E e = (E) circularQueue[front];  //当前队头元素赋值给e
            return  (E) circularQueue[front];
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * @return
     * @description 获取队列中元素个数
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * @return
     * @description 队列判满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;   //队列满条件 (因为引入了一个空位置)
    }

    /**
     * @return
     * @description 队列判空
     */
    public boolean isEmpty() {
        return rear == front;   //队列空条件
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("队列为:");
        for (Object o : circularQueue) {
            sb.append(o);
            sb.append("->");
        }
        sb.append("^");
        return sb.toString();
    }
}
