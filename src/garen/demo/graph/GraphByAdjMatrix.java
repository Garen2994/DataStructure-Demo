package garen.demo.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title : 邻接矩阵表示图
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 14:24
 */
public class GraphByAdjMatrix<E> implements myGraph<E> {
    /**
     * @Title : 图的顶点类
     * @Author : Garen Hou
     * @Email : garen2994@hotmail.com
     * @Date :  2020/1/2 21:01
     */

    public static class Vertex<E> {

        E value;    //顶点值
        boolean isVisited;    //顶点是否被访问

        public Vertex(E value) {
            this.value = value;
            this.isVisited = false;
        }
    }

    public Vertex[] vertexList;  //存储顶点的一维数组
    public int[][] edges;  //邻接矩阵-存储边的二维数组
    public int size;   //当前顶点数

    //用于最小生成树应用
    public int[] distance;  //记录到起点的距离
    public int[] path; //记录最短路径经过的顶点

    /**
     * @param maxSize
     * @return
     * @description 构造方法
     */
    public GraphByAdjMatrix(int maxSize) {
        vertexList = new Vertex[maxSize];
        edges = new int[maxSize][maxSize];
        distance = new int[maxSize];
        path = new int[maxSize];
    }

    /**
     * @param value
     * @return boolean
     * @description 添加边
     */
    @Override
    public boolean addVertex(E value) {
        if (size >= vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("Full list");
        }
        vertexList[size++] = new Vertex<>(value);
        return true;
    }

    /**
     * @param start  弧尾
     * @param end    弧头
     * @param weight 权重
     * @return boolean
     * @description 添加边
     */
    @Override
    public boolean addEdge(int start, int end, int weight) {
        if (start < 0 || start >= edges.length || end < 0 || end >= edges.length) {
            throw new IllegalArgumentException("Wrong vertex");
        }
        edges[start][end] = weight;
        edges[end][start] = weight;
        return true;
    }

    @Override
    public int getNumOfVertex() {
        return size;
    }

    /**
     * @param
     * @return String
     * @description 深度优先搜索
     */
    @Override
    public String dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        vertexList[v].isVisited = true;
        //将第一个节点入栈
        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            sb.append(vertexList[v].value).append(" ");
            for (int i = vertexList.length - 1; i >= 0; i--) {
                if (edges[v][i] != 0 && edges[v][i] != Integer.MAX_VALUE) {
                    if (!vertexList[i].isVisited) {
                        stack.push(i);
                        vertexList[i].isVisited = true;
                    }
                }
            }
        }
        //把所有顶点恢复为未访问
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
    @Override
    public String bfs(int v) {
        if(v < 0 || v >= vertexList.length){
            throw new ArrayIndexOutOfBoundsException("超出索引范围");
        }
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        vertexList[v].isVisited = true;
        //将第一个顶点入队
        queue.add(v);
        while (!queue.isEmpty()) {
            v = queue.remove();
            sb.append(vertexList[v].value).append(" ");
            for (int i = vertexList.length -1 ; i >= 0 ; i--) {
                if(edges[v][i]!=0 && edges[v][i] != Integer.MAX_VALUE){
                    if(!vertexList[i].isVisited){
                         queue.add(i);
                         vertexList[i].isVisited = true;
                    }
                }
            }
        }
        //把所有顶点恢复为未访问
        for (Vertex vertex : vertexList) {
            vertex.isVisited = false;
        }
        return sb.toString().trim();
    }

    /**
     * @param s 源点
     * @return int[]
     * @description 寻找单源最短路径--Dijkstra算法
     */
    @Override
    public int[] dijkstra(int s) {
        if (s < 0 || s > vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("超出索引范围");
        }
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].isVisited = false;
            distance[i] = Integer.MAX_VALUE;
            path[i] = -1;
            for (int j = i + 1; j < vertexList.length; j++) {
                if (edges[i][j] == 0) {
                    edges[i][j] = Integer.MAX_VALUE;
                    edges[j][i] = Integer.MAX_VALUE;
                }
            }
        }
        System.arraycopy(edges[s], 0, distance, 0, vertexList.length);
        vertexList[s].isVisited = true;

        //将源点s邻接点的路径存储
        for (int i = 0; i < vertexList.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < vertexList.length; j++) {
                if (!vertexList[j].isVisited && distance[j] < min) {
                    min = distance[j];
                    k = j;  //记录最短路径加入的顶点
                }
            }
            vertexList[k].isVisited = true;
            for (int j = 0; j < vertexList.length; j++) {
                if (!vertexList[j].isVisited) {
                    if (edges[k][j] != Integer.MAX_VALUE && (min + edges[k][j]) < distance[j]) {
                        distance[j] = min + edges[k][j];
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
