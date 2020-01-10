package garen.demo.graph;

/**
 * @Title : 邻接表表示图
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/10 19:33
 */
public class GraphAdjList<E> implements myGraph<E> {
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
    @SuppressWarnings("all")
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
     * @description 构造方法
     * @param maxSize
     * @return
     */
    @SuppressWarnings("unchecked")
    public GraphAdjList(int maxSize) {
        vertexList = new VNode[maxSize];
        size = -1;
    }
    
    
    @Override
    public int getNumOfVertex() {
        return size;
    }
    
    @Override
    public boolean addVertex(E value) {
        if(size>=vertexList.length){
            throw new ArrayIndexOutOfBoundsException("Full List");
        }
        vertexList[size++] = new VNode<E>(value);
        return true;
    }
    
    @Override
    public boolean addEdge(int s, int v, int weight) {
        return false;
    }
    
    @Override
    public String dfs() {
        return null;
    }
    
    @Override
    public String bfs() {
        return null;
    }
    
    @Override
    public int[] dijkstra(int s) {
        return new int[0];
    }
}
