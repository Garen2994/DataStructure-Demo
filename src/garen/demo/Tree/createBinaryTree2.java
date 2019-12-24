package garen.demo.Tree;

import java.util.Scanner;

/**
 * @Title : 应用前序遍历算法与空节点#来构建二叉树
 * @Author : Garen
 * @Date : 2019/12/23 16:18
 */
@SuppressWarnings("unchecked")
public class createBinaryTree2<E> {
    public static Node createTree(Node node) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the node's value (null is '#')");
        String value = in.next();
        if (!value.equals("#")) {
            node = new Node();
            node.setData(value);
            node.setLchild(createTree(node.getLchild()));
            node.setRchild(createTree(node.getRchild()));
        }else
            node = null;

        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(createTree(tree.getRoot()));
        System.out.println(tree.getRoot());
        System.out.println(tree.getRoot().getData());
        Node root = tree.getRoot();

    }
}
