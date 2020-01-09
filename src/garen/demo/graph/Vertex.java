package garen.demo.graph;
/**
 * @Title : 图的顶点类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/2 21:01
 */

public class Vertex<E>{
    
    public E value;    //顶点值
    
    public boolean isVisited;    //顶点是否被访问
    
    /**
     * @description 默认空构造方法
     * @param
     * @return
     */
    public Vertex() {
    }
    /**
     * @description 构造方法
     * @param value 顶点的值
     * @return
     */
    public Vertex(E value) {
        this.value = value;
        this.isVisited = false;
    }

}

