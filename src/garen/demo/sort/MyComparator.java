package garen.demo.sort;

import java.util.Arrays;

/**
 * @Title : 简易数组版对数器封装
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/11 22:36
 */
public class MyComparator {
    
    public MyComparator() {
    }
    
    /**
     * @param maxSize
     * @param maxValue
     * @return int[]
     * @description step1:生成随机样本
     */
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int arr[] = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    
    /**
     * @param arr
     * @return int[]
     * @description step2:拷贝数组
     */
    public int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        return result;
    }
    
    /**
     * @param
     * @return
     * @description step3:一个绝对正确的方法，实现对数
     */
    public void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    /**
     * @param arr1
     * @param arr2
     * @return boolean
     * @description step4:判断两个数组是否完全相等
     */
    public boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param arr
     * @return void
     * @description step5:打印数组方法
     */
    public void printArray(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("Array is void");
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
