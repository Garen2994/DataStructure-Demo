package garen.demo.heap;

/**
 * @Title : 小根堆：用数组实现；完全二叉树
 * @Description : 堆的相关操作 :堆的创建、堆的删除、堆的插入、堆排序、堆的打印
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/2/12 18:55
 */
public class MinHeap {
    private int[] minHeap;
    private int size;
    
    /**
     * @description 构造方法：构造一个固定大小的小根堆
     * @param maxSize
     * @return
     */
    public MinHeap(int maxSize) {
        minHeap = new int[maxSize];
    }
    
    /**
     * @description 构造方法：初始化并调整为一个小根堆（堆化）
     * @param arr
     * @param maxSize
     * @return
     */
    public MinHeap(int[] arr, int maxSize) {
        minHeap = new int[Math.max(maxSize, arr.length)];
        System.arraycopy(arr, 0, minHeap, 0, arr.length);
        size = arr.length;
        int pos = (size - 2) / 2;
        while(pos >= 0){//自下向上逐步扩展为堆
            shiftDown(pos, size - 1);
            pos--;
        }
    }
    
    /**
     * @param start
     * @return void
     * @description 自下而上的调整为小根堆(如果一个节点比他的父节点小, 向上移动)--用于插入操作
     */
    private void shiftUp(int start) {
        int j = start;
        int i = (j - 1) / 2;
        int temp = minHeap[j];
        while (j > 0) {
            if (minHeap[i] <= temp) {
                break;
            } else {
                minHeap[j] = minHeap[i];
                j = i;
                i = (j - 1) / 2;
            }
        }
        minHeap[j] = temp;
    }
    
    /**
     * @param
     * @return void
     * @description 自上向下调整为小根堆(如果一个节点比他的子节点大, 向下移动)--用于删除操作和建堆
     */
    private void shiftDown(int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = minHeap[i];
        while (j <= end) {
            if (j < end) {
                j = minHeap[j] < minHeap[j + 1] ? j : j + 1;
            }
            if (temp < minHeap[j]) {
                break;
            } else {
                minHeap[i] = minHeap[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        minHeap[i] = temp;
    }
    /**
     * @description 插入元素到小根堆 末尾
     * @param data
     * @return void
     */
    public void insert(int data){
        if(size == minHeap.length){
            throw new RuntimeException("Heap Full");
        }
        if(size < minHeap.length){
            minHeap[size] = data;
            shiftUp(size);
            size++;
        }
    }
    /**
     * @description 删除堆顶元素(即小根堆中的最小元素)
     * @param
     * @return int
     */
    public int remove(){
        if(size == 0){
            throw new NullPointerException("Heap Null");
        }
        int x = minHeap[0];
        minHeap[0] = minHeap[--size];
        shiftDown(0, size);
        return x;
    }
    /**
     * @param i
     * @return void
     * @description 以广义表形式递归输出堆
     */
    public void printMinHeap(int i) {
        if (size > i) {
            System.out.print(minHeap[i]);
            if (2 * i + 1 < size || 2 * i + 2 < size) {
                System.out.print("(");
                printMinHeap(2 * i + 1);
                System.out.print(",");
                printMinHeap(2 * i + 2);
                System.out.print(")");
            }
        }
    }
}


