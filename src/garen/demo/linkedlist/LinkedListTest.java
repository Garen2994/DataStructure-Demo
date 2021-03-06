package garen.demo.linkedlist;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void Test() throws Exception{
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.headAdd(11);
        list.print();
        list.reverseLinkedList();
        list.print();
//        list.reversePrint(list.getHead());
        System.out.println();
        list.printMiddleNodes();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.getKthFromEnd(2).toString());


        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(7);
        list2.add(9);
        list2.add(4);
        list2.add(2);
        list2.print();
//        System.out.println(list.isIntersect(list2));
//        System.out.println(list.getIntersectionPoint(list2));

        LinkedList list3 = new LinkedList();
        list3.createLoopList(list3.getHead()); //建立一个带环单链表
//        list3.print();
        System.out.print("是否有环:");
        System.out.println(list3.hasLoop());
        System.out.println("环的入口结点：" + list3.getEntranceNode(list3.getHead()).data.toString());
        System.out.println("环的长度：" + list3.loopLength(list3.getHead()));
        System.out.println(list3.size());
    }

}