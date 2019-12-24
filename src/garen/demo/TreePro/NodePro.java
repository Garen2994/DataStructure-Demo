package garen.demo.TreePro;
/**
 * @Title : 结点类
 * @Author : Garen
 * @Date : 2019/12/23 16:00
 */
public class NodePro<T> {
    T data;
    NodePro<T> lChild;
    NodePro<T> rChild;
//    boolean isFirst;


    public NodePro(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return data == null ? null : data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodePro) {
            NodePro<T> temp = (NodePro<T>) obj;
            if (data.equals(temp.data)) {
                return true;
            }
        }
        return false;
    }
}
