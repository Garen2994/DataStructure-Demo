package garen.demo.graph;
/**
 * @Title : 边类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 12:55
 */
public class Edge {
    //边的两个顶点
    public int u;
    public int v;
    //权值
    public int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}
