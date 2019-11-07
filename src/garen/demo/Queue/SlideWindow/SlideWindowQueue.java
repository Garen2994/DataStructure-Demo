package garen.demo.Queue.SlideWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Title : 滑动窗口问题之滑动窗口最大值   解法---采用双端队列Deque (底层ArrayDeque\LinkedList实现)
 * @Description : 题目描述:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * @Author : Garen
 * @Date : 2019/10/31 14:00
 */
public class SlideWindowQueue {
    //    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
    public static int[] maxInWindows(int[] num, int size) {
//        ArrayList<Integer> result = new ArrayList<>();

        if (num == null || size == 0 || num.length < size)
//            throw new RuntimeException("错误的输入");
            return new int[0];
        int[] result = new int[num.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>(); //双端递减队列 滑动窗口--记录存储元素在数组中的位置
        int front;
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            front = i - size + 1;   //front--窗口的前端 i--窗口的后端
            if (deque.isEmpty())
                deque.add(i);
                //如果队头元素不在滑动窗口中了,就删除队首元素
            else if (front > deque.peekFirst())  //此时队列元素只差大于k，就要将队首元素移除
                deque.pollFirst();

            //如果当前数字大于队尾元素,就删除队尾,直到当前数字小于等于队尾元素 -- 保持一个递减队列
            while (!deque.isEmpty() && num[deque.getLast()] <= num[i])
                deque.pollLast();

            deque.add(i); //入窗口队列
//            System.out.println(deque.toString());
            //滑动窗口经过size个元素,获取当前最大值,也就是队首元素
            if (front >= 0) {  //形成第一个滑动窗口时开始获取最大值，即队首元素
//                result.add(num[deque.peekFirst()]);
                result[j] = num[deque.peekFirst()];
                j++;
            }

        }
            return result;
    }

        public static void main (String[]args){
//            int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
            int[] num = {};

//            System.out.println(maxInWindows(num, 3).toString());
            System.out.println(Arrays.toString(maxInWindows(num,3)));
        }


    }
