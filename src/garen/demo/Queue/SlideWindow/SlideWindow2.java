package garen.demo.Queue.SlideWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title : 滑动窗口问题之无重复最长子串
 * @Description :   给定一个字符串，找出其中不含有重复字符的最长子串的长度；
 * 维护一个滑动窗口，窗口内的都是没有重复的字符，
 * 去尽可能地扩大窗口的大小，窗口不停地向右滑动。
 * @Author : Garen
 * @Date : 2019/11/4 17:58
 */
public class SlideWindow2 {
    /**
     * @description 用list存储元素位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null)
            throw new RuntimeException("字符串为空串");
        char[] chars = s.toCharArray();
        int result = 0;
        List<Character> arrayList = new LinkedList<>();
        for (char c : chars) {
            if (!arrayList.contains(c)) {
                arrayList.add(c);
                result = Math.max(result, arrayList.size());
            } else {
                int start = arrayList.indexOf(c);
                arrayList = arrayList.subList(start + 1, arrayList.size());    //subList 索引左闭右开
                arrayList.add(c);
            }
        }
        return result;
    }

    /**
     * @description 采用HashMap 因为不需要返回最长子串 只返回其长度即可
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null)
            throw new RuntimeException("字符串为空");

        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur))
                start = Math.max(start, map.get(cur) + 1);
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdbcdefcdac";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
