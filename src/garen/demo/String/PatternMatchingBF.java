package garen.demo.String;

/**
 * @Title : 串的模式匹配---Brute Force法实现(效率低 时间复杂度最好情况O(1)，最坏情况O((n-m+1)*m)-->O(n*m),平均查找(n+m)/2次 ，平均时间复杂度O(n+m)
 * @Description : 串的模式匹配，即查找串，也就是Java中indexOf()函数所实现的功能
 *                  将主串s的第start个字符和模式t的第1个字符比较，若相等，继续逐个比较后续字符；
 *                  若不等，从主串s的下一字符起，重新与t第一个字符比较，直到主串s的一个连续子串字符序列与模式t相等。
 *                  返回值为s中与t匹配的子序列第一个字符的序号，即匹配成功。否则，匹配失败，返回值 –1。
 * @Author : Garen
 * @Date : 2019/11/5 16:41
 */
public class PatternMatchingBF {
    /**
     * @description 返回子串t在主串s中第pos个字符之后的位置
     * @param s
     * @param t
     * @param pos
     * @return
     */
    public static int IndexOf(String s, String t, int pos) {
        if (pos < 0)
            throw new RuntimeException("位置选择错误！");
        int i = pos;
        int j = 0;
        int res = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) { // 匹配
                i++;
                j++;
            } else {
                i = i - j + 1;  //i退回到上次匹配位置的下一位
                j = 0;  //j退回到子串t的首位
            }
        }
        if (j == t.length()) //子串匹配到最后，返回i-j
            res = i - j;  //i-j 差就是匹配的起始位置
        else res = -1;

        return res;
    }
    public static void main(String[] args) {
        System.out.print("匹配的起始字符索引：");
        System.out.println(IndexOf("ABCABAAAABAABCAC", "ABAABCAC",0));

    }
}
