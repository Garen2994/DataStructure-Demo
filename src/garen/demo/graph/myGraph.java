package garen.demo.graph;
/**
 * @Title : 创建图的接口
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/10 14:22
 */
@SuppressWarnings("all")
public interface myGraph<E> {
    int getNumOfVertex();   //获取顶点个数
    boolean addVertex(E value); //添加边
    boolean addEdge(int s, int v, int weight);  //添加顶点
    String dfs();   //深度优先搜索
    String bfs();   //广度优先搜索
    public int[] dijkstra(int s);
}
