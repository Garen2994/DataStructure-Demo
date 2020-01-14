## DataStructure-Demo

![Language](https://img.shields.io/badge/language-Java-green.svg)![author](https://img.shields.io/badge/author-Garen~-blueviolet) ![version](https://img.shields.io/badge/version-jdk12.0.1-9cf)

本项目主要用Java实现常见的数据结构和算法， 持续更新中......
This project mainly uses Java to implement common data structure and algorithms,including linked list,stack,queue,
tree,map and so on. Updating continually...

---

已完成内容：

- [x]  **单向链表的相关操作及算法** :ghost:
    - 插入节点建立链表（头插法、尾插法）
    - 建立一个带环单链表（区分循环链表） 
    ![Looplist](https://github.com/Garen2994/Image/blob/master/img/LoopList%20.png)
    - 判断链表是否带环---------*双指针法*
    - 求得环入口结点
    - 求得环的长度
    - 判断两个链表是否相交
    - 找到两个链表的交点
    - 删除指定结点
    - 删除末尾结点
    - 清空链表
    - 获取链表长度
    - 链表判空
    - 遍历链表
    - 反转链表
    - 逆序输出链表
    - 查找倒数第k个结点-------*双指针法*

*p.s.：**双指针法**(快慢指针)在解决链表相关问题时经常被使用，优点在于：保证时间复杂度为O(n)，空间复杂度为O(1)。*

*（過程中讓我最難解決的不是怎樣判斷有環，求得環的入口結點和環的長度，而是如何建立壹個帶環的單鏈表，沒辦法驗證，後來找了壹下，還是很簡單的嘛，自己好菜kkk。。。）*

----

- [x] **栈的相关操作及算法** :ghost:
  - 建立顺序栈（底层数组）
  - 建立链式栈（底层链表----*Java的LinkedList*）
  - 建立链式栈（底层链表----*自定义链表*）
  - 栈的压栈操作 push
  - 栈的弹栈操作 pop
  - 返回栈顶元素 peek
  - 返回栈大小 size
  - 栈的打印操作 print
  - 最小值栈（时间复杂度O(n) 空间复杂度O(1)）
  - 最小值栈 （带辅助栈优化版----*时间复杂度O(1) 空间复杂度O(n)*）

*（算法渣渣對於優化理解還不是很透徹，這個最小棧的優化做完，有點開了竅貌似。。）*

---

- [x] **队列的相关操作及算法** :ghost:
  （分别基于数组、链表和栈来实现队列）
  - 入队操作
  - 出队操作
  - 获取队首元素
  - 获取队列长度
  - 判断队列是否为空
  - 用两个栈实现一个队列 (底层：链式栈)
  - 顺序存储实现循环队列
  - 滑动窗口问题---用到双端队列(Deque) [稍后滑动窗口相关算法题将作为专题总结]
---

- [x] **串的模式匹配**:ghost:
  （串，也就是字符串，相关操作比较简单，这里只给出串的模式匹配，即查找子串，对应的就是Java中的indexOf()函数。方法分为Brute Force和经典的KMP算法）
  - 朴素模式匹配算法
  - KMP模式匹配算法

---

- [x] **图的相关操作及算法**:ghost:
  （使用图的两种存储结构：邻接矩阵和邻接表，来实现图的相关操作）
  - 邻接矩阵存储带权图
  	- 深度优先搜索（借助栈）
	- 广度优先搜索（借助队列）
	- Dijkstra-单源最短路径算法的实现
  - 邻接表存储带权图
  	- 深度优先搜索
	- 广度优先搜索
	- Dijkstra算法实现（邻接表+最小堆实现） //TODO

*p.s. 更多不常用的算法待补充…*

---

- [ ] 堆的相关操作及算法

  //TODO
