package garen.demo.graph;

import org.junit.jupiter.api.Test;

/**
 * @Title : 图类测试类
 * @Author : Garen Hou
 * @Email : garen2994@hotmail.com
 * @Date :  2020/1/4 19:06
 */
public class GraphTest {
    private Graph g = new Graph(7);
    @SuppressWarnings("unchecked")
    @Test
    public void graphTest(){
        //添加顶点
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
//        int matrix[][] = {
//                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
//         /*A*/ {   0,  12, INF, INF, INF,  16,  14},
//         /*B*/ {  12,   0,  10, INF, INF,   7, INF},
//         /*C*/ { INF,  10,   0,   3,   5,   6, INF},
//         /*D*/ { INF, INF,   3,   0,   4, INF, INF},
//         /*E*/ { INF, INF,   5,   4,   0,   2,   8},
//         /*F*/ {  16,   7,   6, INF,   2,   0,   9},
//         /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        //添加边
        g.addEdge(0,1,12);
        g.addEdge(0, 5, 16); //AF
        g.addEdge(0, 6, 14); //AG
        g.addEdge(1, 2,10);   //BC
        g.addEdge(1, 5, 7);   //BF
        g.addEdge(2, 3,3); //CD
        g.addEdge(2, 4,5); //CE
        g.addEdge(2, 5, 6); //CF
        g.addEdge(3, 4, 4); //DE
        g.addEdge(4, 5, 2); //EF
        g.addEdge(4, 6, 8); //EG
        g.addEdge(5, 6, 9); //FG
        System.out.println("=======深度优先搜索=======");
        System.out.println(g.dfs());
        System.out.println();
        System.out.println("=======广度优先搜索=======");
        System.out.println(g.bfs());
        System.out.println();
    }
}
