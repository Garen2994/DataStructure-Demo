package garen.demo.Stack;

import java.util.Arrays;

/**
 * Title: 顺序栈的实现
 * Description:以数组作为底层实现。(Java的Stack类继承自Vector，同样是用数组来实现)
 *
 * @Author : Garen
 * @Date : 2019/10/17 15:45
 */
public class SequenceStack<E> {
    private Object[] stack;  //底层数组
    private int top;  //栈顶指针
    private int maxSize; //栈最大容量

    public SequenceStack() { //默认生成一个容量为10的栈
        this(10);
    }

    /**
     * @param maxSize
     * @description 生成指定容量的栈
     */
    public SequenceStack(int maxSize) {
        this.stack = new Object[maxSize];
        this.top = -1;
        this.maxSize = maxSize;
    }

    /**
     * @return
     * @throws Exception
     * @description 弹栈操作
     */
    @SuppressWarnings({"unchecked"})
    public E pop() throws Exception {
        if (top == -1) {
            throw new Exception("此栈空！");
        }
        E element = (E) stack[top];
        stack[top--] = null; //删除该元素
        return element;
    }

    /**
     * @param e
     * @throws Exception
     * @description 压栈
     */
    public void push(E e) throws Exception {
        if (top == maxSize - 1)
            throw new Exception("此栈满！");
        stack[++top] = e;
//        stack[top + 1] = e;
//        top = top + 1;
    }

    /**
     * @description 返回栈顶元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if (this.top == -1)
            return null;
        return (E) stack[top];
    }
    public boolean isEmpty(){
        System.out.print("是否是空栈：");
        return top == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
