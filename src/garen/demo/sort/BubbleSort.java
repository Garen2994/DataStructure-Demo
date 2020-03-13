package garen.demo.sort;

/**
 * @Title : 冒泡排序(设置一个标志位)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/13 15:21
 */
public class BubbleSort {
    public BubbleSort() {
    }
    
    /**
     * @description 冒泡排序
     * @param arr
     * @return void
     */
    
    public void bubbleSort(int[] arr){
        int flag = 1;   //设置标志位，如果后面有序就不继续
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length && flag == 1 ; i++) {
            flag = 0;
            for (int j = 1; j < arr.length - i ; j++) {
                if(arr[j-1]>arr[j]){
                    flag = 1;
                    swap(arr,j-1,j);
                }
            }
        }
    }
    private void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
