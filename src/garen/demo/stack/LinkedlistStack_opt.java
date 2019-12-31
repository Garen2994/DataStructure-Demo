package garen.demo.stack;

import java.util.Comparator;

/**
 * @Title : 优化版最小栈(使用一个辅助栈来存最小值，以空间换时间)
 * @Descirption : 采用辅助栈的优化版最小栈，与主栈同步push和pop-------时间复杂度O(1),空间复杂度O(n)
 * @Author : Garen
 * @Date : 2019/10/18 13:55
 */
public class LinkedlistStack_opt<E> {
    private Node<E> top; //栈顶元素
    private int size; //链式栈大小
    private LinkedlistStack_opt<E> minStack;   //辅助栈

    public LinkedlistStack_opt() {
    }

    public void push(E data) {
        Node<E> node = new Node<E>(data);
        node.next = top;
        top = node;
        size++;
    }

    /**
     * @description 最小值辅助栈 压栈
     * @param data
     * @param c
     */
    public void push(E data, Comparator<? super E> c){  //采用Comparator接口的compare方法比较再排序，省去复杂的强制类型转换
        push(data);
        if(minStack == null){
            minStack = new LinkedlistStack_opt<E>();
        }
        if (minStack.peek() == null){
            minStack.push(data);
        }else if(c.compare(this.peek().data,minStack.peek().data) < 0){
            minStack.push(data);
        }
    }

    /**
     * @description 弹栈
     */
    public Node<E> pop(){
        if (isEmpty())
            return null;

        Node<E> node = top;
        top = top.next;
        node.next = null;
        size--;
        return node;
    }

    /**
     * @description 最小值辅助栈 压栈
     * @param c
     * @return
     */
    public Node<E> pop(Comparator<? super E> c){
        Node<E> temp = this.pop();
        if (temp != null && minStack.peek() != null){
            if(c.compare(temp.data, minStack.peek().data) == 0){
                minStack.pop();
            }
        }
        return temp;
    }
    public Node<E> min(){
        System.out.print("此栈最小值为：");
        if(minStack.peek() == null) {
            return null;
        }else{
            return minStack.peek();
        }

    }

    public Node<E> peek() {
        if (isEmpty())
            return null;
        return top;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void print() {
        Node<E> index = top;
        while (index != null) {
            System.out.print(index.data + "->");
            index = index.next;
        }
        System.out.print("^");
        System.out.println();
    }

    /**
     * @description 栈的大小
     * @return
     */
    public int size(){
        return size;
    }

    public LinkedlistStack_opt<E> getMinStack() {
        return minStack;
    }

}
