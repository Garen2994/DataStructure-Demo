package garen.demo.Stack;

public class StackDemo {
    public static void main(String[] args) throws Exception{
        SequenceStack<String> stack = new SequenceStack<String>();
        stack.push("Garen");
        stack.push("Ariana");
        stack.push("Ross");
        stack.push("Chandler");

        System.out.println(stack);

        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

        LinkedStack<String> stack1 = new LinkedStack<String>();
        stack1.push("a1");
        stack1.push("b2");
        stack1.push("c3");
        stack1.push("d4");
        stack1.pop();
        System.out.println(stack1.peek());
        System.out.println(stack1.size());
        System.out.println(stack1.isEmpty());
        System.out.println(stack1);

        System.out.println("==========最小栈==========");
        LinkedlistStack<Integer> stack3 = new LinkedlistStack<>();
        stack3.push(10);
        stack3.push(5);
        stack3.push(9);
        stack3.push(11);
        stack3.push(2);
        stack3.print();
        System.out.println(stack3.getMin());
        stack3.pop();
        stack3.print();
//        System.out.println(stack3.peek().data.toString());
        System.out.println(stack3.getMin());

    }
}
