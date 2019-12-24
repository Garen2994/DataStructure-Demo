package garen.demo.Queue;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    /**
     * @description 链式队列测试
     */
    public void linkedQueueTest() {

        SeqQueue<Integer> queue = new SeqQueue<Integer>(6);
        queue.add(20);
        queue.add(18);
        queue.add(16);
        queue.add(14);
        queue.add(12);
        queue.add(10);
//        queue.add(8);
        queue.remove();
        System.out.println(queue.element());
//        queue.add(6);
        System.out.println(queue.toString());
        System.out.println("============链式队列==============");
        LinkedListQueue<String> queue1 = new LinkedListQueue<>();
        queue1.add("Garen");
        queue1.add("Sun");
        queue1.add("Olivia");
        queue1.add("Bitch");
        queue1.add("Sheila");
        System.out.println(queue1.toString());
        queue1.remove();
        queue1.remove();
        queue1.remove();

        System.out.println(queue1.toString());
        System.out.println(queue1.size());
        System.out.println(queue1.peek());

        System.out.println(queue1.isEmpty());
    }

    @Test
    /**
     * @description 两个栈实现队列测试
     */
    public void stackQueueTest() {
        System.out.println("============两个栈实现队列==============");
        StackQueue<Integer> queue3 = new StackQueue<>();
        queue3.add(1);
        queue3.add(2);
        queue3.add(3);
        queue3.add(4);
        queue3.add(5);
        System.out.println(queue3.toString());
        System.out.println("队头元素:" + queue3.peek().toString());
        queue3.remove();
        System.out.println(queue3.toString());
        System.out.println("队头元素:" + queue3.peek().toString());
        queue3.remove();
        System.out.println(queue3.toString());
        System.out.println("队头元素:" + queue3.peek().toString());
    }
    @Test
/**
 * @description 循环队列测试
 */
    public void CircularQueueTest() {
        System.out.println("==================循环队列================");
        CircularQueue<String> queue4 = new CircularQueue<>(8);
        queue4.push("Karl");
        queue4.push("Rob");
        queue4.push("Jade");
        queue4.push("Simone");
        queue4.push("Naomi");
        queue4.push("Tommy");
        queue4.pop();
        System.out.println(queue4.size());
        System.out.println(queue4.toString());
    }
}
