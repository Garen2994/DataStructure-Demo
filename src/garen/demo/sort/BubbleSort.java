package garen.demo.sort;

public class BubbleSort {
    //TODO
    
    
    public static void main(String[] args) {
        int testTime = 5;
        boolean succeed = true;
        MyComparator myComparator = new MyComparator();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = myComparator.generateRandomArray(100, 100);
            int[] arr2 = myComparator.copyArray(arr1);
//            insertionSort(arr1);
            myComparator.comparator(arr2);
            if (!myComparator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Something Wrong!");
    }
}
