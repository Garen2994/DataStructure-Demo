package garen.demo.stack;

/**
 * @Title : 实现两栈共享空间(利用顺序栈底层实现)，包括两个指针top1、top2，stackSize两个栈共享空间的大小
 * @Description : 栈空状态为 top1=0 top2=stackSize-1
 * @Author : Garen
 * @Date : 2019/10/29 20:02
 */
public class DoubleStack<E> {
    private Object[] doubleStack;
    private int top1;
    private int top2;
    private int stackSize;
    /**
     * @param stackSize
     */
    public DoubleStack(int stackSize) {
        this.stackSize = stackSize;
        doubleStack = new Object[stackSize];
        top1 = -1;
        top2 = stackSize;
    }

    /**
     * @param i
     * @param e
     * @description 压栈, 选择压入栈1, 还是栈2  栈满条件top1+1 = top2
     */
    public void push(int i, E e) {
        if (top1 + 1 == top2)
            throw new StackOverflowError("此共享栈满");
        else {
            if (i == 1)
                doubleStack[++top1] = e;
            else if (i == 2) {
                doubleStack[--top2] = e;
            } else
                throw new RuntimeException("选择栈错误");

        }
    }

    /**
     * @param i
     * @return
     * @description 选择两个栈之一进行弹栈
     */
    @SuppressWarnings({"unchecked"})
    public E pop(int i) throws RuntimeException {
        if (i == 1) {
            if (top1 == -1)
                throw new RuntimeException("栈1空");
            return (E) doubleStack[top1--];
        } else if (i == 2) {
            if (top2 == stackSize)
                throw new RuntimeException("栈2空");
            return (E) doubleStack[top2++];

        } else {
            throw new RuntimeException("选择栈错误");
        }
    }

    /**
     * @param i
     * @return
     * @description 选择返回两栈栈顶元素
     */
    @SuppressWarnings({"unchecked"})
    public E peek(int i) {
        if (i == 1) {
            if (top1 == -1)
                throw new RuntimeException("栈1空");
            return (E) doubleStack[top1];
        } else if (i == 2) {
            if (top2 == stackSize)
                throw new RuntimeException("栈2空");
            return (E) doubleStack[top2];
        } else {
            throw new RuntimeException("选择栈错误");
        }
    }

    public int size() {
        return (top1 + 1) + (stackSize - top2);
    }

    /**
     * @return
     * @description 判空
     */
    public boolean isEmpty() {
        return (top1 == -1 && top2 == stackSize);
    }

    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        str1.append("栈1：");
        StringBuilder str2 = new StringBuilder();
        str2.append("栈2：");

        for (int i = top1; i >= 0; i--)
            str1.append(doubleStack[i]).append("->");
        str1.append("^");
        for (int i = top2; i < stackSize; i++)
            str2.append(doubleStack[i]).append("->");
        str2.append("^");

        return str1.toString() + "\n\r" + str2.toString();
    }
}
