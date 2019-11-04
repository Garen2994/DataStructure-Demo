package garen.demo.Queue;

public class LinkedlistStack<E> {
    private Node<E> top; //栈顶元素
    private int size; //链式栈大小

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
    }

    /**
     * @description 弹栈
     * @return
     */
    public Node<E> pop() {

        if (this.isEmpty())
            return null;

        Node<E> node = top;
        top = top.next;
        node.next = null; //释放结点
        size--;
        return node;
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

    public void print() {
        Node<E> index = top;
        while (index != null) {
            System.out.print(index.data + "—>");
            index = index.next;
        }
        System.out.print("^"); //^是栈底
        System.out.println();
    }
    public int size(){
            return size;
        }
        public String toString() {
            // TODO Auto-generated method stub
            Node<E> index = top;
            StringBuilder sb = new StringBuilder();
            while (index != null) {
                sb.append(index.data).append(" ");
                index = index.next;
            }
            return sb.toString();
    }
}
