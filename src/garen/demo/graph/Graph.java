package garen.demo.graph;

import java.util.LinkedList;

/**
 * @Title : 图类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 14:24
 */
public class Graph<E> {
    private Vertex[] vertexList;  //顶点
    private int[][] mGraph;  //用矩阵表示边
    
    //用于图的遍历
    private LinkedList<Integer> stack;     //栈 (存要访问的节点的索引)
    private LinkedList<Integer> queue;     //队列 （存索引）
    private int size;   //当前顶点
    
    //用于最小生成树应用
    private int[] distance;  //记录到起点的距离
    private int[] path; //记录最短路径经过的顶点
    private int[][] dist;    //dist[i][j]记录i到j的最短距离
    private int[][] prev;    //prev[i][j]=k表示i到j的最短路径会经过顶点k
//     int[] parent; //并查集

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
    @SuppressWarnings("unchecked")
    public boolean addVertex(E value) {
        if (size == vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("Full list");
        }
        vertexList[++size] = new Vertex(value);
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
     * @description 深度优先搜索
     * @param
     * @return String
     */
    public String dfs() {
         StringBuilder sb = new StringBuilder();
         sb.append(vertexList[0].value).append(" ");
         vertexList[0].isVisited = true;
         stack.push(0);  //将第一个节点入栈
         while(!stack.isEmpty()){
              int v = getUnvisitedVertex(stack.peek());
              if(v == -1){
                   stack.pop();
              }else{
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
     * @description 广度优先搜索
     * @param
     * @return String
     */
    public String bfs(){
         StringBuilder sb = new StringBuilder();
         sb.append(vertexList[0].value).append(" ");
         vertexList[0].isVisited = true;
         queue.add(0);   //将第一个顶点入队
         while(!queue.isEmpty()){
              int v = getUnvisitedVertex(queue.peek());
              if(v!=-1){
                   sb.append(vertexList[v].value).append(" ");
                   vertexList[v].isVisited = true;
                   queue.add(v);
              }else{
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
//    /**
//     * @description 寻找单源最短路径--Dijkstra算法
//     * @param s 起始点
//     * @return void
//     */
//    public void dijkstra(int s){
//
//    }
}
