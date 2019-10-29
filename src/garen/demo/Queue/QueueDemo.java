package garen.demo.Queue;

import garen.demo.Stack.LinkedlistStack;

public class QueueDemo {
    public static void main(String[] args) {
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
}
