package garen.demo.Stack;

/**
 * @Title : 栈相关的算法题：最小栈
 * @Descirption : 带有取最小值getMin方法的栈，getMin方法将返回当前栈中的最小值(这里假设栈中元素为int型)
 *  -----这个方法时间复杂度O(n),空间复杂度O(1)
 * @Author : Garen
 * @Date : 2019/10/17 20:48
 */
public class LinkedlistStack<E> {
    private Node<E> top; //栈顶元素
    private int size; //链式栈大小
    private int min = Integer.MAX_VALUE;

    public LinkedlistStack() {

    }

    /**
     * @description 压栈(自己实现底层链表),在压栈同时更新最小值
     * @param data
     *
     */

    public void push(E data) {

        Node<E> node = new Node<E>(data);
        node.next = top;
        top = node;
        size++;

        if (min >= (int)data) {
            min = (int)data;
        }
    }

    /**
     * @description 弹栈,如果最小值被弹出，则需要遍历栈重新找最小值 -------此时pop()时间复杂度为O(n),空间复杂度为O(1)
     * @return
     */
    public void pop() throws Exception {
        if ((int) top.data == min) {
            min = Integer.MAX_VALUE;
            Node<E> index = top.next;
            while (index != null) {
//                System.out.print(index.data + " ");
                if ((int) index.data < min) {
                    min = (int)index.data;
                }
                index = index.next;
            }

        }
        if (this.isEmpty())
            throw new Exception("此栈空！");
        Node<E> node = top;
        top = top.next;
        node.next = null; //释放结点
        size--;

    }
    /**
     * @return
     * @description 获取栈顶元素
     */
    public Node<E> peek() {
        if (this.isEmpty())
            return null;
        return top;
    }

    /**
     * @return
     * @description 判空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        System.out.print("此栈最小值为：");
        return min;
    }

    public void print() {
        Node<E> index = top;
        while (index != null) {
            System.out.print(index.data + "—>");
            index = index.next;
        }
        System.out.print("^"); //^是栈底
        System.out.println();
    }
}
