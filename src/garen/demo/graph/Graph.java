package garen.demo.graph;

import java.util.LinkedList;

/**
 * @Title : 图类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 14:24
 */
public class Graph<E> {
    public Vertex<E>[] vertexList;  //顶点
    public int[][] mGraph;  //用矩阵表示边
    
    //用于图的遍历
    
    public LinkedList<Integer> stack;  //栈 (存要访问的节点的索引)
    public LinkedList<Integer> queue;  //队列 （存索引）
    public int size;   //当前顶点数
    
    //用于最小生成树应用
    public int[] distance;  //记录到起点的距离
    public int[] path; //记录最短路径经过的顶点
    public int[][] dist;    //dist[i][j]记录i到j的最短距离
    public int[][] prev;    //prev[i][j]=k表示i到j的最短路径会经过顶点k
//     int[] parent; //并查集
    
    /**
     * @description 构造方法
     * @param maxSize
     * @return
     */
    public Graph(int maxSize) {
        vertexList = new Vertex[maxSize];
        mGraph = new int[maxSize][maxSize];
        stack = new LinkedList<>();
        queue = new LinkedList<>();
        size = -1;
        distance = new int[maxSize];
        path = new int[maxSize];
        dist = new int[maxSize][maxSize];
        prev = new int[maxSize][maxSize];
        init();
    }
    
    /**
     * @description 初始化为没有边的图
     * @param
     * @return void
     */
    public void init() {
        for (int i = 0; i < mGraph.length; i++) {
            for (int j = 0; j < mGraph.length; j++) {
                if (i == j) {
                    mGraph[i][j] = 0;
                } else {
                    mGraph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
    }
    
    /**
     * @description 添加边
     * @param value
     * @return boolean
     */
    public boolean addVertex(E value) {
        if (size == vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("Full list");
        }
        vertexList[++size] = new Vertex<E>(value);
        return true;
    }
    
    /**
     * @description 添加边
     * @param start  弧尾
     * @param end    弧头
     * @param weight 权重
     * @return boolean
     */
    public boolean addEdge(int start, int end, int weight) {
        if (start < 0 || start >= mGraph.length || end < 0 || end >= mGraph.length) {
            throw new IllegalArgumentException("Wrong vertex");
        }
        mGraph[start][end] = weight;
        mGraph[end][start] = weight;
        return true;
    }
    
    /**
     * @description 深度优先搜索
     * @param
     * @return String
     */
    public String dfs() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertexList[0].value).append(" ");
        vertexList[0].isVisited = true;
        //将第一个节点入栈
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].isVisited = true;
                sb.append(vertexList[v].value).append(" ");
                stack.push(v);
            }
        }
        for (Vertex<E> vertex : vertexList) {
            vertex.isVisited = false;
        }
        return sb.toString().trim();
    }
    
    /**
     * @description 广度优先搜索
     * @param
     * @return String
     */
    public String bfs() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertexList[0].value).append(" ");
        vertexList[0].isVisited = true;
        //将第一个顶点入队
        queue.add(0);
        while (!queue.isEmpty()) {
            int v = getUnvisitedVertex(queue.peek());
            if (v != -1) {
                sb.append(vertexList[v].value).append(" ");
                vertexList[v].isVisited = true;
                queue.add(v);
            } else {
                queue.remove();
            }
        }
        return sb.toString().trim();
    }
    
    /**
     * @description 找到与某一顶点邻接但未被访问的顶点
     * @param v 某一顶点
     * @return int
     */
    public int getUnvisitedVertex(int v) {
        for (int i = 0; i < mGraph.length; i++) {
            //v顶点与i顶点相邻（邻接矩阵值为1）且未被访问 isVisited==false
            if (v != i && mGraph[v][i] < Integer.MAX_VALUE && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * @description 寻找单源最短路径--Dijkstra算法
     * @param s 起始点
     * @return void
     */
    public void dijkstra(int s) {
        //初始化距离和路径
        for (int i = 0; i < vertexList.length; i++) {
            distance[i] = Integer.MAX_VALUE; //到源点的距离设置为无穷大
            path[i] = -1; //到源点的路径初始化为-1
        }
        distance[s] = 0;
        //处理从源点到其余顶点的最短路径
        for (int i = 0; i < vertexList.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < vertexList.length; j++) {
                if (!vertexList[j].isVisited && distance[j] < min) {
                    vertexList[j].isVisited = true;
                    min = distance[j];
                    k = j;   //记录最小路径的顶点符号
                }
            }
            
            //修正当前最短路径和前驱结点
            for (int j = 0; j < vertexList.length; j++) {
                //找顶点k的临界点j，并更新它的邻接点到起点的最短路径
                int temp = (mGraph[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + mGraph[k][j]));
                if (!vertexList[j].isVisited && (temp < distance[j])) {
                    distance[j] = temp;
                    path[j] = k;
                }
            }
        }
        // 打印Dijkstra最短路径的结果
        printDijkstra(s);
        //恢复visited为false，方便下次访问
        for (Vertex<E> vertex : vertexList) {
            vertex.isVisited = false;
        }
    }
    
    /**
     * @description 打印Dijkstra最短路径的结果
     * @param s
     * @return void
     */
    public void printDijkstra(int s) {
        //利用栈后进先出的特性，将路径逆序
        LinkedList<Integer> stack = new LinkedList<>();
        System.out.printf("dijkstra(%c): \n", (char) vertexList[s].value);
        for (int i = 0; i < vertexList.length; i++) {
            System.out.printf("  shortest(%c, %c)=%d 路径为：", (Character) vertexList[s].value, (Character) vertexList[i].value, distance[i]);
            //这里可以用一个栈来存储顶点，然后出栈就是顺序输出了，而不是反向输出
            //打印路径
            stack.push(i);  //终点
            int temp = path[i];
            while (temp != -1) {
                stack.push(temp);
                temp = path[temp];
            }
            while (!stack.isEmpty()) {
                System.out.printf("%c-->", (Character) vertexList[stack.pop()].value);
            }
            System.out.println();
        }
    }
}