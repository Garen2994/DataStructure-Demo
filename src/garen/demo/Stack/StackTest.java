package garen.demo.Stack;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class StackTest {
    @Test
    public void Test() throws Exception {
        SequenceStack<String> stack = new SequenceStack<String>();
        stack.push("Garen");
        stack.push("Ariana");
        stack.push("Ross");
        stack.push("Chandler");

        System.out.println(stack);

        stack.pop();
//        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }

    @Test
    public void Test1(){
        System.out.println("==========最小栈==========");
        LinkedlistStack<Integer> stack = new LinkedlistStack<>();
        stack.push(10);
        stack.push(5);
        stack.push(9);
        stack.push(11);
        stack.push(2);
        stack.print();
        System.out.println(stack.getMin());
        stack.pop();
        stack.print();
//        System.out.println(stack.peek().data.toString());
        System.out.println(stack.getMin());
    }
    @Test
    public void Test2() {
        System.out.println("======最小栈(优化版)==========");
        LinkedlistStack_opt<Integer> stack = new LinkedlistStack_opt<>();
        Comparator<? super Integer> c = Integer::compareTo;   //调用最小值栈需要传入Comparator
        stack.push(3,c);
        stack.push(6,c);
        stack.push(68,c);
        stack.push(8,c);
        stack.push(74,c);
        stack.push(2,c);
        stack.print();
        System.out.print("最小栈：");
        stack.getMinStack().print();
        System.out.println(stack.min());
//        System.out.println(stack.pop(c));
        stack.pop(c);  //弹出的是当前的最小值时
        stack.print();
        System.out.print("最小栈：");
        stack.getMinStack().print();
        System.out.println(stack.min());
    }
    @Test
    public void Test3(){
        DoubleStack<String> stack = new DoubleStack<>(10);
        stack.push(1,"Simone");
        stack.push(1,"Tommy");
        stack.push(1,"Eli");
        stack.push(1,"Taylor");
        stack.push(2,"Jade");
        stack.push(2,"Karl");
        stack.push(2,"Rob");
        stack.push(2,"Emily");
        stack.pop(1);
        stack.push(1,"Naomi");
        stack.pop(2);
        System.out.println("栈内元素个数:"+stack.size());
        System.out.println("栈1栈顶:"+stack.peek(1));
        System.out.println("栈2栈顶:"+stack.peek(2));
        System.out.println(stack.toString());
    }
}
