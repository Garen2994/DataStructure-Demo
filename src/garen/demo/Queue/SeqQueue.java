package garen.demo.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @Title : 队列的三种实现方法之一：基于数组的实现
 * @Description ：顺序队列
 * @Author : Garen
 * @Date : 2019/10/22 23:19
 */
public class SeqQueue<E> {
    private Object[] queue;
    private int size;
    private int maxSize;

    public SeqQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
    }

    /**
     * @param data
     * @description 添加元素到队尾
     */
    public void add(E data) {
        if (!isFull()) {
            queue[size] = data;
            size++;
        } else {
            throw new IllegalStateException("队列已满，入队失败");
        }

    }

    /**
     * @return
     * @description 移除并返回队头的元素
     */
    public E remove() {
        if (!isEmpty()) {
            E temp = (E) queue[0];
            for (int i = 0; i < size-1; i++)
                queue[i] = queue[i + 1];
            queue[size - 1] = null;
            size--;
            return temp;
        } else {
            throw new NoSuchElementException("队列为空，出队失败");
        }
    }

    /**
     * @return
     * @description 获取队头元素
     */
    @SuppressWarnings("unchecked")
    public E element() {
        if (!isEmpty()) {
            return (E) queue[0];
        } else {
            throw new NoSuchElementException("队列为空，获取失败");
        }
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return
     * @description
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
