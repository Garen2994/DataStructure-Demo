package garen.demo.graph;
/**
 * @Title : 图的顶点类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/2 21:01
 */

public class Vertex<E>{
    //顶点值
    public E value;
    //顶点是否被访问
    public boolean isVisited;

    public Vertex() {
    }

    public Vertex(E value) {
        this.value = value;
        this.isVisited = false;
    }

}

