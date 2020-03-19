package garen.demo.sort;

/**
 * @Title : 归并排序（分治）
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/19 23:40
 */
public class MergeSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }
    
    public static void sortProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
//        int mid = (left + right) / 2;
        int mid = left + ((right - left) >> 1);   //>>算术右移相当于倍增倍减
        sortProcess(arr, left, mid);
        sortProcess(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p = left;
        int q = mid + 1;
        while (p <= mid && q <= right) {
            temp[i++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        //两个必有且只有一个越界
        while (p <= mid) {
            temp[i++] = arr[p++];
        }
        while (q <= left) {
            temp[i++] = arr[q++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
