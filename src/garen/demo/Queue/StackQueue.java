package garen.demo.Queue;

/**
 * @Title :　使用两个栈模拟一个队列
 * @Description : 栈的特性是后进先出，队列的特性是先进先出，他们的顺序刚好是相反的：
 * stack1作为入队存储数据的栈，stack2作为缓冲栈，出队时先把s1中其他数据取出然后加入到s2中，
 * s2再压入到s1中，这样s1弹栈的时候就实现了出队的功能。
 * @Author : Garen
 * @Date : 2019/10/29 14:29
 */
public class StackQueue<E> {
    private LinkedlistStack<E> stack1;
    private LinkedlistStack<E> stack2;

    public StackQueue() {
        stack1 = new LinkedlistStack<>();
        stack2 = new LinkedlistStack<>();
    }

    /**
     * @param data
     * @description 添加元素到队尾，先要保证stack2中是空的，即所有的元素全部pop完
     */
    public void add(E data) {
        if (!stack2.isEmpty()) {
            while (stack2.size() > 0) {
                stack1.push(stack2.pop().getData());
            }
        }
        stack1.push(data);
    }

    /**
     * @return
     * @description 队头出队并返回队头元素，先检查stack2是否为空：
     * 若为空，将stack1中的size-1个元素压入stack2中，再对stack1执行弹栈
     * 否则，直接对stack2执行弹栈
     */
    public E remove() {

        if (stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                while (stack1.size() > 1) { //stack2已是空栈，要再出队要把stack1中元素压入stack2
                    stack2.push(stack1.pop().getData());
                }
                return stack1.pop().getData(); //stack1中只剩一个元素 直接弹栈就是出队
            }
            return null; //如果两栈都为空，队列为空
        } else {
            return stack2.pop().getData();  //如果stack2有元素，出队就stack2弹栈
        }
    }

    /**
     * @description 返回队头元素
     * @return
     */
    public E peek(){
        if (stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                while (stack1.size() > 1) { //stack2已是空栈，要再出队要把stack1中元素压入stack2
                    stack2.push(stack1.pop().getData());
                }
                return stack1.peek().getData(); //stack1中只剩一个元素 直接弹栈就是出队
            }
            return null; //如果两栈都为空，队列为空
        } else {
            return stack2.peek().getData();  //如果stack2有元素，出队就stack2弹栈
        }
    }

    @Override
    public String toString() {
        if (!stack1.isEmpty()) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop().getData());
            }
            return new StringBuilder(stack2.toString()).toString();
        }
        return new StringBuilder(stack2.toString()).toString();

    }
}