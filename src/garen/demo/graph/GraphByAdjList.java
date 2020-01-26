package garen.demo.graph;

import java.util.LinkedList;
import java.util.Queue;

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
     * @Title : 顶点表结点
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
     * @Title : 边表结点
     * @Author : Garen Hou
     * @Date :  2020/1/10 19:57
     */
    @SuppressWarnings("unused")
    private static class ENode {
        int vertex; //邻接顶点索引
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
        if (vertexList[s].firstVertex != null) {  //有邻接头结点
            v1.nextVex = vertexList[s].firstVertex; //头插法
        }
        vertexList[s].firstVertex = v1;

        ENode v2 = new ENode(s, weight);
        if (vertexList[v].firstVertex != null) {
            v2.nextVex = vertexList[v].firstVertex;
        }
        vertexList[v].firstVertex = v2;
        return true;
    }

    /**
     * @param
     * @return String
     * @description 深度优先搜索
     */
    @Override
    public String dfs(int v) {
        if (v < 0 || v > vertexList.length - 1) {
            throw new ArrayIndexOutOfBoundsException("超出索引范围");
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(v);
        vertexList[v].isVisited = true;
        ENode current;
        while (!stack.isEmpty()) {
            v = stack.pop();
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
        for (VNode<E> vNode : vertexList) {
            vNode.isVisited = false;
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
        if (v < 0 || v > vertexList.length) {
            throw new ArrayIndexOutOfBoundsException("超出索引范围");
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        vertexList[v].isVisited = true;
        ENode current;
        while (!queue.isEmpty()) {
            v = queue.remove();
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
        //把所有顶点恢复为未访问
        for (VNode<E> vNode : vertexList) {
            vNode.isVisited = false;
        }
        return sb.toString().trim();
    }

    @Override
    public int[] dijkstra(int s) {
        //TODO 用邻接表+最小堆实现
        return new int[0];
    }
}
