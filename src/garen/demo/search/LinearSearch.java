package garen.demo.search;

/**
 * @Title : 顺序查找
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/2/5 21:11
 */
public class LinearSearch {
    
    public LinearSearch() {
    }
    
    public int seqSearch(int[] seq, int key) {
        if (seq.length == 0) {
            throw new NullPointerException("序列为空");
        }
        for (int i = 0; i < seq.length; i++) {
            if (key == seq[i]) {
                return i;
            }
        }
        System.out.println("Not Found !");
        return -1;
    }
    
    /**
     * @description 折半查找（非递归）
     * @param seq
     * @param key
     * @return int
     */
    public int binarySearch(int[] seq, int key) {
        if (seq.length == 0) {
            throw new NullPointerException("序列为空");
        }
        int low = 0;
        int high = seq.length - 1;
        int mid ;
        while(low <= high){
            mid = (low + high) / 2;
            if(key < seq[mid]){
                high = mid - 1;
            }else if (key > seq[mid]){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        System.out.println("Not Found !");
        return -1;
    }
    /**
     * @description 折半查找（递归）
     * @param seq
     * @param key
     * @param low
     * @param high
     * @return int
     */
    public int binarySearchWithRecursion(int[] seq, int key, int low, int high){
        if (seq.length == 0) {
            throw new NullPointerException("序列为空");
        }
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(key == seq[mid]){
            return mid;
        }else if(key < seq[mid]){
            return binarySearchWithRecursion(seq,key,low,mid - 1);
        }else{
            return binarySearchWithRecursion(seq,key,mid + 1,high );
        }
    }
}
