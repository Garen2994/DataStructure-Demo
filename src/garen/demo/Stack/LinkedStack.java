package garen.demo.Stack;

import java.util.LinkedList;

/**
 * @Author : Garen
 * @Date : 2019/10/17 17:31
 */

public class LinkedStack<E> {

    private LinkedList<E> stack;//底层链表

    /**
     * @description 创建链式栈
     */
    public LinkedStack() {
        stack = new LinkedList<E>();
    }

    /**
     * @description 判空
     * @return
     */
    public boolean isEmpty() {
        System.out.print("是否是空栈：");
        return stack.isEmpty();
    }

    /**
     * @description 弹栈
     * @return
     */
    public E pop() {
        if (stack.isEmpty())
            return null;
        return stack.removeLast();
    }

    /**
     * @description 压栈
     * @param e
     */
    public void push(E e) {
        stack.addLast(e);
    }

    /**
     * @description 获取栈顶元素
     * @return
     */
    public E peek(){
        System.out.print("栈顶元素为：");
        return stack.getLast();
    }

    public int size(){
        System.out.print("栈的大小：");
        return stack.size();
    }
    @Override
    public String toString() {
        return stack.toString();
    }
}
