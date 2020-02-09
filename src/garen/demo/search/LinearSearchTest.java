package garen.demo.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Title : 线性表查找测试类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/2/5 22:38
 */
public class LinearSearchTest {
    LinearSearch search = new LinearSearch();
    @Test
    public void SeqSearchTest(){
        int[] seq = {23,45,34,29,65,54,30,20,80};
        System.out.println("查找元素的索引为:" + search.seqSearch(seq, 80));
    }
    @Test
    public void binarySearchTest(){
        int[] seq = {23,45,34,29,65,54,30,20,80};
        Arrays.sort(seq);
        System.out.println(Arrays.toString(seq));
        System.out.println("查找元素的索引为：" + search.binarySearch(seq, 45));
    }
    @Test
    public void binarySearchWithRecursionTest(){
        int[] seq = {23,45,34,29,65,54,30,20,80};
        Arrays.sort(seq);
        System.out.println(Arrays.toString(seq));
        System.out.println("查找元素的索引为：" + search.binarySearchWithRecursion(seq, 45, 0, seq.length-1));
    }
}
