package garen.demo.sort;

import java.util.Arrays;

/**
 * @Title : 插入排序及对数器测试
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/8 0:31
 */
public class InsertSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j + 1, j);
            }
        }
    }
    
    public static void insertionSortWithSentinel(int[] arr) {
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
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    
    public static void main(String[] args) {
        int testTime = 5;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
            insertionSort(arr1);
            myComparator.comparator(arr2);
            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
        
        System.out.println("带哨兵排序（arr[0]为哨兵位不在排序范围内，初始化为0）");
        int[] arrWithSentinel = {0, -6, -1, 3, -90, -76, 89, -5, 37, 14, 26};
        insertionSortWithSentinel(arrWithSentinel);
        for (int i = 1; i < arrWithSentinel.length; i++) {
            System.out.print(arrWithSentinel[i] + " ");
        }
        System.out.println();
    }
    
}




