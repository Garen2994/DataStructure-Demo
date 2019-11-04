### 滑动窗口相关算法题

 滑动问题包含一个滑动窗口，它是一个运行在一个大数组上的子列表，该数组是一个底层元素集合。 一般情况下，滑动窗口问题就是使用一个固定长度的窗口在数组的**合法区间**内进行滑动，同时**动态地**记录一些有用的数据,能够极大地提升算法的效率。

##### 1.滑动窗口最大值

**题目描述**： 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。 返回滑动窗口最大值。 【LeetCode No.239】

**示例**：

> 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
> 输出: [3,3,5,5,6,7] 
>
> 解释:
>
>  滑动窗口的位置        最大值
>
>  [1 3 -1] -3 5 3 6 7          3
>  1 [3 -1 -3] 5 3 6 7          3
>  1 3 [-1 -3 5] 3 6 7          5
>  1 3 -1 [-3 5 3] 6 7          5
>  1 3 -1 -3 [5 3 6] 7          6
>  1 3 -1 -3 5 [3 6 7]          7 

**题目解析**：利用一个双端队列，**在队列中存储元素在数组中的位置**，并维持队列的严格**递减**， 也就说维持队首元素是最大的，当遍历到一个新元素时, 如果队列里有比当前元素小的，就将其移除队列，以保证队列的递减。当队列元素位置之差大于 k，就将队首元素移除。

>**双端队列**（Deque）：Deque 的含义是 “double ended queue”，即双端队列，它具有队列和栈的性质的数据结构。顾名思义，它是一种前端与后端都支持插入和删除操作的队列。
>
>Java中，Deque 继承自 Queue（队列），它的直接实现有 ArrayDeque、LinkedList 等。这里使用的是ArrayDeque

​                          <img src="https://github.com/Garen2994/Image/blob/master/img/2019082811400912.gif" alt="Slide-Window" style="zoom:65%;" position = “center" />

**实现代码**：
```java
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
	        ArrayList<Integer> result = new ArrayList<>();
	        if (num == null || size == 0 || num.length < size)
	            throw new RuntimeException("错误的输入");
	
	         Deque<Integer> deque = new ArrayDeque<>(); //双端递减队列 滑动窗口--记录存储元素在数组中的位置
	         int front;
	         for (int i = 0; i < num.length; i++) {
	             front = i - size + 1;   //front--窗口的前端 i--窗口的后端
	             if (deque.isEmpty())
	                 deque.add(i);
	                 //如果队头元素不在滑动窗口中了,就删除队首元素
	             else if (front > deque.peekFirst())  //此时队列元素只差大于k，就要将队首元素移除
	                 deque.pollFirst();
	
	             //如果当前数字大于队尾元素,就删除队尾,直到当前数字小于等于队尾元素 -- 保持一个递减队列
	             while (!deque.isEmpty() && num[deque.getLast()] <= num[i])
	                 deque.pollLast();
	
	             deque.add(i); //入窗口队列
	             System.out.println(deque.toString());
	             //滑动窗口经过size个元素,获取当前最大值,也就是队首元素
	             if (front >= 0)  //形成第一个滑动窗口时开始获取最大值，即队首元素
	                 result.add(num[deque.peekFirst()]);
	         }
	         return result;
	     }
```

##### 2.无重复字符的最长子串

**题目描述**：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

**示例**：

> 输入: "abcabcbb"
> 输出: 3 
> 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

**题目解析**：因为不需要返回字符串，所以使用map，key是字符，value是字符所在的索引的下一个值

- i 是字串的起点，j 是子串的重点，j 一直往前走遍历整个字符串
- 后面与前面字符重复的话，i 就会从重复的字符下一个开始，重新构建一个字串
- hashmap的key值是唯一的

维护一个滑动窗口，窗口内的都是没有重复的字符，去**尽可能地扩大窗口的大小**，窗口不停地向右滑动。

<img src="https://github.com/Garen2994/Image/blob/master/img/2019082811400913.gif" style="zoom:65%;" position="center"/>

代码：

```java
解法1：  
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
解法2：
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
```

