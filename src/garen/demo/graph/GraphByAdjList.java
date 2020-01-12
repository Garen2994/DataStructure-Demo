package garen.demo.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title : 邻接表表示图:顺序存储与链式存储相结合
 * 顺序存储部分用来保存图中的顶点信息（一维数组）
 * 链式存储部分用来保存图中边或弧的信息 （）
 * 具体的做法是，使用一个保存图中顶点的信息
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/10 19:33
 */
public class GraphByAdjList<E> implements myGraph<E> {
    /**
     * @Title : 邻接表数组顶点类
     * @Author : Garen Hou
     * @Date :  2020/1/10 20:14
     */
    @SuppressWarnings("unused")
    private static class VNode<E> {
        E data; //顶点信息
        ENode firstVertex;  //对应的单链表的头指针
        boolean isVisited;
        
        public VNode() {
        }
        
        public VNode(E data) {
            this.data = data;
            this.isVisited = false;
        }
    }
    
    /**
     * @Title : 单链表的顶点
     * @Author : Garen Hou
     * @Date :  2020/1/10 19:57
     */
    @SuppressWarnings("unused")
    private static class ENode {
        int vertex; //邻接顶点符号
        int weight; //权重
        ENode nextVex;  //下一个邻接表节点
        
        /**
         * @param vertex
         * @param weight
         * @return
         * @description //构造方法
         */
        public ENode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    private VNode<E>[] vertexList;  //顶点数组
    private int size;   //顶点数
    private boolean isVisited;  //是否被访问过
    
    /**
     * @param maxSize
     * @return
     * @description 构造方法
     */
    @SuppressWarnings("unchecked")
    public GraphByAdjList(int maxSize) {
        vertexList = new VNode[maxSize];
    }
    
    
    @Override
    public int getNumOfVertex() {
        return size;
    }
    
    @Override
    public boolean addVertex(E value) {
        if (size >= vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("Full List");
        }
        vertexList[size++] = new VNode<>(value);
        return true;
    }
    
    /**
     * @param s
     * @param v
     * @param weight
     * @return boolean
     * @description 添加边
     */
    @Override
    public boolean addEdge(int s, int v, int weight) {
        if (s < 0 || v < 0 || s > vertexList.length || v > vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("超出集合索引范围");
        }
        ENode v1 = new ENode(v, weight);
        
        //索引为s没有邻接头结点
        if (vertexList[s].firstVertex == null) {
            vertexList[s].firstVertex = v1;
        } else {  //有邻接头结点
            v1.nextVex = vertexList[s].firstVertex; //头插法
            vertexList[s].firstVertex = v1;
        }
        
        ENode v2 = new ENode(s, weight);
        if (vertexList[v].firstVertex == null) {
            vertexList[v].firstVertex = v2;
        } else {
            v2.nextVex = vertexList[v].firstVertex;
            vertexList[v].firstVertex = v2;
        }
        return true;
    }
    
    /**
     * @param
     * @return String
     * @description 深度优先搜索
     */
    @Override
    public String dfs() {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        sb.append(vertexList[0].data).append(" ");
        //将第一个节点入栈
        stack.push(0);
        vertexList[0].isVisited = true;
        ENode current;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            sb.append(vertexList[v].data).append(" ");
            current = vertexList[v].firstVertex;
            while (current != null) {
                if (!vertexList[current.vertex].isVisited) {
                    stack.push(current.vertex);
                    vertexList[current.vertex].isVisited = true;
                }
                current = current.nextVex;
            }
        }
        return sb.toString().trim();
    }
    
    /**
     * @param
     * @return String
     * @description 广度优先搜索
     */
    @Override
    public String bfs() {
        if (vertexList.length == 0) {
            throw new NullPointerException("顶点集为空");
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        vertexList[0].isVisited = true;
        ENode current;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            sb.append(vertexList[v].data).append(" ");
            current = vertexList[v].firstVertex;
            while (current != null) {
                if (!vertexList[current.vertex].isVisited) {
                    queue.add(current.vertex);
                    vertexList[current.vertex].isVisited = true;
                }
                current = current.nextVex;
            }
        }
        return sb.toString().trim();
    }
    
    @Override
    public int[] dijkstra(int s) {
        return new int[0];
    }
}
