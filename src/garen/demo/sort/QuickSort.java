package garen.demo.sort;

/**
 * @Title : 快速排序 !!!(好奇妙~)
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/3/13 19:02
 */
public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length < 2) return;
        if (low < high) {
            int pivot = Partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    
    /**
     * @Title : 一趟快排
     * @Author : Garen Hou
     * @Email : garen2994@hotmail.com
     * @Date :  2020/3/13 23:32
     */
    private int Partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= key) {
                high--;
            }
            // 如果队尾元素小于key了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= key) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
            
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = key;
        return low; // 返回tmp的正确位置
    }
}
