package garen.demo.Stack;

import java.util.Comparator;

public class StackDemo {
    public static void main(String[] args) throws Exception{
//        SequenceStack<String> stack = new SequenceStack<String>();
//        stack.push("Garen");
//        stack.push("Ariana");
//        stack.push("Ross");
//        stack.push("Chandler");
//
//        System.out.println(stack);
//
//        stack.pop();
////        stack.pop();
//        stack.pop();
//        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
//
//        LinkedStack<String> stack1 = new LinkedStack<String>();
//        stack1.push("a1");
//        stack1.push("b2");
//        stack1.push("c3");
//        stack1.push("d4");
//        stack1.pop();
//        System.out.println(stack1.peek());
//        System.out.println(stack1.size());
//        System.out.println(stack1.isEmpty());
//        System.out.println(stack1);
//
//        System.out.println("==========最小栈==========");
//        LinkedlistStack<Integer> stack3 = new LinkedlistStack<>();
//        stack3.push(10);
//        stack3.push(5);
//        stack3.push(9);
//        stack3.push(11);
//        stack3.push(2);
//        stack3.print();
//        System.out.println(stack3.getMin());
//        stack3.pop();
//        stack3.print();
////        System.out.println(stack3.peek().data.toString());
//        System.out.println(stack3.getMin());
//
//        System.out.println("======最小栈(优化版)==========");
//        LinkedlistStack_opt<Integer> stack4 = new LinkedlistStack_opt<>();
//        Comparator<? super Integer> c = Integer::compareTo;   //调用最小值栈需要传入Comparator
//        stack4.push(3,c);
//        stack4.push(6,c);
//        stack4.push(68,c);
//        stack4.push(8,c);
//        stack4.push(74,c);
//        stack4.push(2,c);
//        stack4.print();
//        System.out.print("最小栈：");
//        stack4.getMinStack().print();
//        System.out.println(stack4.min());
////        System.out.println(stack4.pop(c));
//        stack4.pop(c);  //弹出的是当前的最小值时
//        stack4.print();
//        System.out.print("最小栈：");
//        stack4.getMinStack().print();
//        System.out.println(stack4.min());

        DoubleStack<String> stack3 = new DoubleStack<>(10);
        stack3.push(1,"Simone");
        stack3.push(1,"Tommy");
        stack3.push(1,"Eli");
        stack3.push(1,"Taylor");
        stack3.push(2,"Jade");
        stack3.push(2,"Karl");
        stack3.push(2,"Rob");
        stack3.push(2,"Emily");
        stack3.pop(1);
        stack3.push(1,"Naomi");
        stack3.pop(2);
        System.out.println("栈内元素个数:"+stack3.size());
        System.out.println("栈1栈顶:"+stack3.peek(1));
        System.out.println("栈2栈顶:"+stack3.peek(2));
        System.out.println(stack3.toString());
    }
}
