package garen.demo.sort;

import org.junit.jupiter.api.Test;

/**
 * @Title : 排序测试类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/13 20:47
 */
public class SortTest {
    @Test
    public void insertionSortTest() {
        InsertSort is = new InsertSort();
        int testTime = 500000;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
            is.insertionSort(arr1);
            myComparator.comparator(arr2);
            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
        System.out.println("带哨兵排序（arr[0]为哨兵位不在排序范围内，初始化为0）");
        int[] arrWithSentinel = {0, -6, -1, 3, -90, -76, 89, -5, 37, 14, 26};
        is.insertionSortWithSentinel(arrWithSentinel);
        for (int i = 1; i < arrWithSentinel.length; i++) {
            System.out.print(arrWithSentinel[i] + " ");
        }
    }
    
    @Test
    public void BubbleSortTest() {
        BubbleSort bs = new BubbleSort();
        int testTime = 50000;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
            bs.bubbleSort(arr1);
            myComparator.comparator(arr2);

            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
                
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
    }
    
    @Test
    public void QuickSortTest() {
        QuickSort qs = new QuickSort();
        int testTime = 100000;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
            qs.quickSort(arr1);
            myComparator.comparator(arr2);
            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                myComparator.printArray(arr1);
                myComparator.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
    }
    
    @Test
    public void MergeSortTest() {
        MergeSort ms = new MergeSort();
        int testTime = 50000;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
            ms.mergeSort(arr1);
            myComparator.comparator(arr2);
            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
    }
}
