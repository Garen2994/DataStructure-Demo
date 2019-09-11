package garen.demo.Linkedlist;

/**
 * @Author : Garen
 * @Date : 2019/9/11 15:03
 */

public class LinkedListDemo {
    public class Node {
        private int data;
        private Node next = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node temp;

    public LinkedListDemo() {
        head = new Node();
    }

    /**
     * 插入节点 建立链表---尾插法
     *
     * @param data
     */

    public void addNode(int data) {

        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next; //让temp为末尾结点
        }
        temp.next = new_node;
    }

    /**
     * 插入节点 建立链表---头插法
     *
     * @param data
     */
    public void headAddNode(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head.next;
        head.next = new_node;
    }

    /**
     * 指定位置插入结点
     *
     * @param data
     * @param index
     */
    public void insertNode(int data, int index) {

        if (index < 1 || index > getLength()) {
            System.out.println("插入位置不合理！");
        }
        Node p = head;
        int j = 1;
        while (p != null && j < index) {
            p = p.next;
            j++;
        }
//        if(p == null || j > index)
//            return;
        Node insert_node = new Node(data);
        insert_node.next = p.next;
        p.next = insert_node;

    }

    /**
     * 删除指定位置的结点
     *
     * @param index
     */
    public void deleteElem(int index) {
        if (index == 1)
            System.out.println("该节点为头节点 不要删除！");
        if (index < 1 || index > getLength()) {
            System.out.println("要删除的位置不存在！");
        }
        Node p = head;
        int j = 2;
        while (p != null && j < index) {
            p = p.next;
            j++;
        }
        Node q = p.next;
        if (j == index) {
            p.next = p.next.next;
        }
    }

    /**
     * 清空链表
     */
    public void clearList(){
        Node p = head;
        Node q = new Node();
        int j = -1;
        while(p != null && j <= getLength()){
            q = p.next;
            p.next = q.next;
            j++;
        }
    }

    /**
     * 获取指定位置的结点数据
     *
     * @param index
     * @return result
     */
    public Node getElem(int index) {
        Node result = new Node();
        if (index < 1 || index > getLength()) {
            System.out.println("该位置没有结点 获取错误！");
        }
        Node temp = head;
        int j = 1;
        while (temp != null && j < index) {
            temp = temp.next;
            j++;
        }
        if (j == index) {
            result = temp;
        }
        return result;
    }

    /**
     * 获取链表的长度
     *
     * @return length
     */
    public int getLength() {
        int length = 0;
        Node current_node = head;
        while (current_node != null) {
            length++;
            current_node = current_node.next;
        }
        return length;
    }

    /**
     * 链表判空
     * @return true or false
     */
    public boolean isEmpty(){
        Node temp = head;
        if(temp.next == null)
            return true;
        else
            return false;
    }

    //遍历链表
    public void printList() {
        Node current_node = head;
        while (current_node.next != null) {
            System.out.print(current_node.next.data + "->");//头节点的数据不需要输出
            current_node = current_node.next;
        }
        System.out.println("^");
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
//        list.addNode(1);
//        list.addNode(2);
//        list.addNode(3);
//        list.addNode(4);
        list.headAddNode(1);
        list.headAddNode(2);
        list.headAddNode(3);
        list.headAddNode(4);
        int length = list.getLength();
        System.out.println("链表长度为: " + length);
        list.printList();
        list.insertNode(9, 3);
        list.printList();
        Node result = list.getElem(4);
        System.out.println("获取的结点存储的值为: " + result.data);

        list.deleteElem(2);
        list.printList();

        list.clearList();
        list.addNode(3);
        boolean isempty = list.isEmpty();
        System.out.println("链表是否为空：" + isempty);
        list.printList();

    }
}
