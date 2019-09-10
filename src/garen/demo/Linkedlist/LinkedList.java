package garen.demo.Linkedlist;

public class LinkedList {
    public static void main(String[] args) {
        //头节点
        Node head = new Node(-1,null);
        //第一个节点
        Node firstNode = new Node(0,null);
        //链接
        head.setNext(firstNode);
        System.out.println(head.getValue() + " "+ head.getNext().getValue());

    }
}
