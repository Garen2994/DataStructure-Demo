package garen.demo.graph;

import java.util.LinkedList;

/**
 * @Title : 图类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 14:24
 */
public class Graph<E> {
    public Vertex[] vertexList;  //顶点
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
     * @param maxSize
     * @return
     * @description 构造方法
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
     * @param
     * @return void
     * @description 初始化为没有边的图
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
     * @param value
     * @return boolean
     * @description 添加边
     */
    public boolean addVertex(E value) {
        if (size == vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("Full list");
        }
        vertexList[++size] = new Vertex<E>(value);
        return true;
    }
    
    /**
     * @param start  弧尾
     * @param end    弧头
     * @param weight 权重
     * @return boolean
     * @description 添加边
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
     * @param
     * @return String
     * @description 深度优先搜索
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
        for (Vertex vertex : vertexList) {
            vertex.isVisited = false;
        }
        return sb.toString().trim();
    }
    
    /**
     * @param
     * @return String
     * @description 广度优先搜索
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
     * @param v 某一顶点
     * @return int
     * @description 找到与某一顶点邻接但未被访问的顶点
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
     * @param s 源点
     * @return int[]
     * @description 寻找单源最短路径--Dijkstra算法
     */
    public int[] dijkstra(int s) {
        if (s < 0 || s > vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("超出索引范围");
        }
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].isVisited = false;
            distance[i] = Integer.MAX_VALUE;
            path[i] = -1;
            for (int j = i + 1; j < vertexList.length; j++) {
                if (mGraph[i][j] == 0) {
                    mGraph[i][j] = Integer.MAX_VALUE;
                    mGraph[j][i] = Integer.MAX_VALUE;
                }
            }
        }
        System.arraycopy(mGraph[s], 0, distance, 0, vertexList.length);
        vertexList[s].isVisited = true;
        
        //将源点s邻接点的路径存储
        for (int i = 0; i < vertexList.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < vertexList.length; j++) {
                if (!vertexList[j].isVisited && distance[j] < min) {
                    min = distance[j];
                    k = j; //记录最短路径加入的顶点
                }
            }
            vertexList[k].isVisited = true;
            for (int j = 0; j < vertexList.length; j++) {
                if (!vertexList[j].isVisited) {
                    if (mGraph[k][j] != Integer.MAX_VALUE && (min + mGraph[k][j]) < distance[j]) {
                        distance[j] = min + mGraph[k][j];
                        path[j] = k;
                    }
                }
                
            }
        }
        printDijkstra(s);
        return distance;
    }
    
    public void printDijkstra(int s) {
        LinkedList<Integer> stack = new LinkedList<>();
        System.out.println("dijkstra(" + vertexList[s].value + ")");
        for (int i = 0; i < vertexList.length; i++) {
            System.out.printf("  shortest(%c, %c)=%d 路径为：", vertexList[s].value, vertexList[i].value, distance[i]);
            //这里可以用一个栈来存储顶点，然后出栈就是顺序输出了，而不是反向输出
            //打印路径
            stack.push(i);  //终点
            int tmp = path[i];
            while (tmp != -1) {
                stack.push(tmp);
                tmp = path[tmp];
            }
            System.out.print(vertexList[s].value + "-->");
            while (!stack.isEmpty()) {
                System.out.printf("%c-->", vertexList[stack.pop()].value);
            }
            System.out.println();
        }
    }
}
