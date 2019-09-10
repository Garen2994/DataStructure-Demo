package garen.demo.Linkedlist;

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

    //插入节点---尾插法
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
    //头插法
    public void headAddNode(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head.next;
        head.next = new_node;
    }

//    public void insertNode(int data, int index){
//        if(index < 1 || index > )
//
//    }

    /*
    * 获取链表长度(包括头结点)
    * @return length
    */
    public int getLength(){
        int length = 0;
        Node current_node = head;
        while(current_node != null){
            length++;
            current_node = current_node.next;
        }
        return length;
    }

    //遍历链表
    public void printData(){
        Node current_node = head;
        while(current_node.next != null){
            System.out.print(current_node.next.data +"->");//头节点的数据不需要输出
            current_node = current_node.next;
        }
        System.out.print("^");
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
        System.out.println("链表长度为：" + length);
        list.printData();

    }
}
