package garen.demo.String;

/**
 * @Title : 串的模式匹配---KMP算法实现
 * @Description :KMP算法思想：利用已经部分匹配这个有效信息，保持i指针不回溯，通过修改j指针，让模式串尽量地移动到有效的位置，
 * 重点就在于当某一个字符与主串不匹配时，我们应该知道j指针要移动到哪里。
 * @Author : Garen
 * @Date : 2019/11/5 17:28
 */
public class PatternMatchingKMP {

    public static int[] getNext(String T) {
//        char[] P = T.toCharArray();
        int[] next = new int[T.length()];
        int j = 0;
        next[0] = -1;
        int k = -1;
        while (j < T.length() - 1) {
            if (k == -1 || T.charAt(k) == T.charAt(j))
                next[++j] = ++k;
            else
                k = next[k];
        }
        return next;
    }
    public static int IndexKMP(String S, String T) {
        int i = 0;
        int j = 0;
        int[] next = getNext(T);
        while (i < S.length() && j < T.length()) {
            if (j == 0 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];  //对比BF解法，i不需要回溯
        }
        if (j == T.length())
            return i - j;
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.print("匹配的起始字符索引：");
        System.out.println(IndexKMP("abcacaaaabaabcac", "abaabcac"));

    }
}
