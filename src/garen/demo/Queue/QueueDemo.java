package garen.demo.Queue;

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
    }
}
