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
    
    public MinHeap(int[] arr, int maxSize) {
        minHeap = new int[Math.max(maxSize, arr.length)];
        System.arraycopy(arr, 0, minHeap, 0, arr.length);
        size = arr.length;
        
        int pos = (size - 2) / 2;  //最初调整位置：最后叶节点的父亲节点
        while (pos >= 0) {  //依次调整每个分支节点
            shiftDown(pos, size - 1);
            pos--;
        }
        
    }
    
    /**
     * @description 自下而上的调整为小根堆(如果一个节点比他的父节点小, 向上移动)--用于插入操作
     * @param start
     * @return void
     */
    private void shiftUp(int start) {
        int j = start;
        int i = (j - 1) / 2;  //起始调整位置：分支节点
        int temp = minHeap[j];
        while (j > 0) { //迭代条件：子节点不为根
            if (temp >= minHeap[i]) { //只需比较这个子女与父亲的关系即可
                break;
            } else {
                minHeap[j] = minHeap[i];    //父节点小于子节点，交换；子节点上移
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
        int i = start;  //最后一个节点的父亲节点（0开始）
        int j = 2 * start + 1;     //最后一个节点
        int temp = minHeap[i];
        while (j <= end) {    //迭代条件：子节点不能超出end范围
            if (j < end) {
                j = minHeap[j] > minHeap[j + 1] ? j + 1 : j;//选择较小的孩子
            }
            if (temp < minHeap[j]) {
                break;
            } else {    //交换父节点与较小的孩子节点
                minHeap[i] = minHeap[j];
                i = j;
                j = 2 * j + 1;//该节点子树进行递归
            }
        }
        minHeap[i] = temp;
    }
    public void printMinHeap(int i){
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

