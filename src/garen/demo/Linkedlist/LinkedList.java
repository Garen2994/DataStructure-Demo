package garen.demo.Linkedlist;
/**
 * @Author : Garen
 * @Date : 2019/10/15 17:15
 */

/**
 * @ title: 链表的建立以及各种操作
 * @ description:   链表结构包含两个要素： 头结点head + 链表大小size，操作包括：
 * * 				链表的增删
 * * 				链表是否为空
 * * 				链表的大小
 * * 				链表的打印输出
 * * 				删除链表重复节点
 * *  			    链表倒数第K个元素
 * *  			    链表的反转
 * *  			    链表的倒序输出
 * *  			    链表的中间节点
 * *  			    链表是否有环
 * *  			    链表节点的删除(不知道头结点的情况下)
 * *  			    链表是否相交
 * *  			    链表的交点
 */
public class LinkedList<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null); //调用链表构造方法自动生成头结点
    }
    public void createLoopList(Node<E> head){

        int i;
        Node<E> current = head;
        Node<E> target = null;
        for (i = 0; i < 10; i++) {
            Node<E> temp= new Node(i);
            temp.next = null;
            current.next = temp;
            this.size++;
            if (i == 5)
                target = temp;//指定这个节点为环的第一个节点
            current = temp;
        }
        current.next = target;  //链表末端指向中间的一个节点，这样就创建了一个带环单链表
    }
    public Node<E> getHead() {
        return head;
    }

    /**
     * @param data
     * @param index
     * @return insert_node
     * @throws Exception
     * @description 将新结点插入链表
     */
    public Node<E> add(E data, int index) throws Exception {
        if (index < 0 || index > size) {
            System.out.println("插入位置不合理！");
        }
        Node<E> p = head;

        int j = 0;
        while (p != null && j < index) {
            p = p.next;
            j++;
        }
//        if(p == null || j > index)
//            return;
        Node<E> insert_node = new Node<E>(data);
        insert_node.next = p.next;
        p.next = insert_node;
        size++;

        return insert_node;
    }

    /**
     * @param data
     * @return
     * @throws Exception
     */
    public Node<E> add(E data) throws Exception {  //尾插法
        return add(data, size);
    }

    public Node<E> headAdd(E data) throws Exception {  //头插法
        return add(data, 0);
    }

    /**
     * @param node
     * @description 插入新结点
     */
    public void add(Node<E> node) {

        Node<E> p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node;

        while (node != null) {
            size++;
            node = node.next;
        }
    }

    /**
     * @param index
     * @return
     * @throws Exception
     * @description 删除链表中指定位置的结点
     */
    public E remove(int index) throws Exception {
        if (index > size - 1 || index < 0) {
            throw new Exception("删除位置不合理...");
        }
        Node<E> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        Node<E> temp = p.next;
        p.next = temp.next;
        temp.next = null;

        size--;
        return temp.data;
    }

    /**
     * @return
     * @throws Exception
     * @description 删除链表末尾结点
     */
    public E remove() throws Exception {
        return remove(size - 1);
    }

    /**
     * @description 删除链表中的重复结点 ------------------时间复杂度：O(n^2)
     */
    public void removeRepeatedNodes() {
        Node<E> p = head.next;
        while (p != null) { // 外循环
            Node<E> temp = p;
            while (temp != null && temp.next != null) { // 内循环
                if (p.data.equals(temp.next.data)) {
                    Node<E> repeatedNode = temp.next;
                    temp.next = repeatedNode.next;
                    repeatedNode.next = null;
                    size--;
                }
                temp = temp.next;
            }
            p = p.next;
        }
    }

    /**
     * @param k
     * @return
     * @description 找出单链表中倒数第K个元素(前提 : 不知道size ; 双指针法, 相差K - 1步) --------------------时间复杂度：O(n)
     */
    public Node<E> getKthFromEnd(int k) {
        System.out.print("倒数第" + k + "个结点为: ");
        Node<E> pre = head.next;
        Node<E> post = head.next;
        for (int i = 1; i < k; i++) { // pre先走k-1步
            if (pre != null) {
                pre = pre.next;
            }
        }
        if (pre != null) {
            // 当pre走到链表末端时，post正好指向倒数第K个节点
            while (pre != null && pre.next != null) {
                pre = pre.next;
                post = post.next;
            }
            return post;
        }
        return null;
    }

    /**
     * @description 反转链表（前指针，后指针，每个结点的next都要更新）
     */
    public void reverseLinkedList() {
        System.out.print("反转后链表为: ");
        Node<E> cur = head.next; // 原链表
        Node<E> pre = null; // 反转后的链表

        while (cur != null) { // 对原链表中的每个结点进行反转
            Node<E> next = cur.next;  //记录当前结点的下一个结点
            cur.next = pre; //更新当前结点的next
            pre = cur; //pre后移
            cur = next; //
        }
        head.next = pre;
    }

    /**
     * @param head
     * @description 递归法逆输出链表(不改变原链表)
     */
    public void reversePrint(Node<E> head) {
        if (head.next != null) {
            reversePrint(head.next);
            System.out.print(head.next.data + " ");
        }
    }

    /**
     * @return
     * @description 链表判空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @description 打印输出单链表
     */
    public void print() {
        Node<E> p = head.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * @description 寻找单链表中的中间节点(双指针法)
     * @author rico
     */
    public void printMiddleNodes() {
        Node<E> index1 = head.next; // 慢指针
        Node<E> index2 = head.next; // 快指针
        if (head.next == null) {
            System.out.println(index1.data);
        }
        while (index2 != null && index2.next != null
                && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        System.out.println("链表中间结点为：" + index1.data); // 第一个中间节点
        if (index2.next != null) { // 当链表长度为偶数时，打印第二个中间节点
            System.out.println("链表中间结点为：" + index1.next.data);
        }
    }

    /**
     * @return
     * @description 判断单链表是否有环(双指针法)--------------时间复杂度O(n);空间复杂度O(1)[设置标志位空间复杂度大]
     * @author rico
     */
    public boolean hasLoop() {
        Node<E> pre = head.next;
        Node<E> post = head.next;

        if (pre == null)
            return false;
        while (pre != null && pre.next != null && pre.next.next != null) {
            post = post.next;   //慢指针走一步
            pre = pre.next.next;   //快指针走两步
            if (pre == post)
                return true;
        }
        return false;

    }

    /**
     * @param node
     * @return
     * @description 不知道头结点前提下，删除指定节点
     */
    public boolean deleteNodeWithoutHead(Node<E> node) {
        if (node == null || node.next == null) { // 当指定节点为空或者为尾节点时，无法删除
            return false;
        }

        Node<E> next = node.next;

        // 将后继节点的内容复制到当前节点
        node.data = next.data;
        node.next = next.next;

        // 将后继节点清空
        next.next = null;
        next.data = null;
        return true;
    }

    /**
     * @param list2
     * @return
     * @description 判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)
     */
    public boolean isIntersect(LinkedList<E> list2) {
        Node<E> cur1 = head.next;   // 当前链表
        Node<E> cur2 = list2.getHead().next;  // 目标链表

        // 两链表有一个为空，则返回 false
        if (cur1 == null || cur2 == null) {
            return false;
        }

        // 遍历到第一个链表的尾节点
        while (cur1.next != null) {
            cur1 = cur1.next;
        }

        // 遍历到第二个链表的尾节点
        while (cur2.next != null) {
            cur2 = cur2.next;
        }

        return cur1 == cur2;  // 尾节点是否相同
    }

    /**
     * @param list2
     * @return
     * @description 返回两链表的交点(若不相交 ， 返回null)
     */
    public Node<E> getIntersectionPoint(LinkedList<E> list2) {
        Node<E> cur1 = head.next;
        Node<E> cur2 = list2.getHead().next;
        if (this.isIntersect(list2)) {
            int step = Math.abs(this.size - list2.size);
            if (this.size > list2.size) {
                while (step > 0) {
                    cur1 = cur1.next;
                    step--;
                }
            } else if (this.size < list2.size) {
                while (step > 0) {
                    cur2 = cur2.next;
                    step--;
                }
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        return null;
    }

    /**
     * @description 找到环的入口结点：相遇点到连接点的距离=头指针到连接点的距离
     * @param head
     * @return
     *
     */
    public Node<E> getEntranceNode(Node<E> head) {
        Node<E> pre = head.next;
        Node<E> post = head.next;
        if (pre == null || pre.next == null)
            return null;
        while (pre != null && pre.next != null && pre.next.next != null) {
            if (post == pre) {
                System.out.println("有环");
                break;
            }//相等，则单链表有环
            post = post.next;
            pre = pre.next.next;
        }
        post = head; //此时,两个指针都在相遇节点处,让一个指针指向头结点处,另一个指向相遇结点
        while(post != pre){
            post = post.next; //两个指针同时前进，最后一定相遇在环入口结点
            pre = pre.next;
        }
        return pre; //环入口结点
    }

    /**
     * @description 求环的长度：让指针指向入口节点，遍历直到回到入口节点，走过的长度即环的长度
     * @param head
     * @return
     */
    public int loopLength(Node<E> head){
        if (!this.hasLoop()) {
            return 0;
        }
        int length = 1;
        Node<E> enter = this.getEntranceNode(this.getHead());
        Node<E> cur = enter.next;
        while(cur != null) { //从环入口开始再回到环。
            length++;
            cur = cur.next;
            if (cur == enter) {
                return length;
            }
        }
        return length;
    }

    /**
     * @return
     * @description 返回链表的长度
     */
    public int size() {
        System.out.print("链表长度为: ");
        return size;
    }
}
