package garen.demo.heap;

import org.junit.jupiter.api.Test;

/**
 * @Title : 小根堆相关操作类MinHeap测试类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/2/14 1:37
 */
public class MinHeapTest {
    @Test
    public void test(){
        int[] arr = {53, 17, 78, 9, 45, 65, 87, 23};
        MinHeap heap = new MinHeap(arr,20);
        System.out.print("堆对应的广义表为：");
        heap.printMinHeap(0);
    }

}
