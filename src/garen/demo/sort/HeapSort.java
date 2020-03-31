package garen.demo.sort;

import java.util.Arrays;

/**
 * @Title : 堆排序 ***
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/28 0:32
 */
public class HeapSort {
    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); //建堆
        }
        int size = arr.length;
        swap(arr, 0, --size); //排序：把堆顶和最后元素交换，再heapify
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    
    /**
     * @param arr
     * @param i
     * @param size
     * @return void
     * @description 大根堆调整(从上到下)
     */
    private void heapify(int[] arr, int i, int size) {
        int left = i * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[i] ? largest : i;
            if (largest == i) {
                break; //后面不执行
            }
            swap(arr, largest, i);
            i = largest;
            left = i * 2 + 1;
        }
    }
    
    /**
     * @param arr
     * @param i
     * @return void
     * @description 建大根堆(从下到上)
     */
    private void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
