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
        int[] arr = {9,2,3,5,6,7,10,1};
        MinHeap heap = new MinHeap(arr,9);
        System.out.print("堆对应的广义表为：");
        heap.printMinHeap(0);
        System.out.println();
        System.out.println("===============插入元素==============");
        heap.insert(4);
        System.out.print("堆对应的广义表为：");
        heap.printMinHeap(0);
        System.out.println();
        System.out.println("===============删除元素==============");
        System.out.println("删除的元素：" + heap.remove());
        System.out.print("堆对应的广义表为：");
        heap.printMinHeap(0);
    }

}
