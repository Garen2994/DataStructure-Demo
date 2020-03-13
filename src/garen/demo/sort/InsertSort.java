package garen.demo.sort;

/**
 * @Title : 插入排序及对数器测试
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/8 0:31
 */
public class InsertSort {
    
    public InsertSort() {
    }
    /**
     * @description 插入排序
     * @param arr
     * @return void
     */
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j + 1, j);
            }
        }
    }
    
    public void insertionSortWithSentinel(int[] arr) {
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            arr[0] = arr[i];
            for (int j = i - 1; arr[0] < arr[j]; j--) {
                arr[j + 1] = arr[j];
                arr[j] = arr[0];
            }
        }
    }
    /**
     * @param arr
     * @param i
     * @param j
     * @return void
     * @description 交换两数
     */
    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
}




