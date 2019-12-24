package garen.demo.Tree;

import java.util.Scanner;

/**
 * @Title : 应用前序遍历算法与空节点#来构建二叉树
 * @Author : Garen
 * @Date : 2019/12/23 16:18
 */
public class createBinaryTree2<E> {
    public static Node createTree(Node node) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the node's value (null is '#')");
        String value = in.next();
        if (!value.equals("#")) {
            node = new Node();
            node.data = value;
            node.lchild = createTree(node.lchild);
            node.rchild = createTree(node.rchild);
        }else
            node = null;

        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = createTree(tree.root);
        System.out.println(tree.root);
        System.out.println(tree.root.data);
        Node root = tree.root;

        System.out.println("=======Pre-order=======");
        root.frontShow();
        System.out.println("");
        System.out.println("======Medium-order=======");
        root.midShow();
        System.out.println("");
        System.out.println("=======Post-order=======");
        root.afterShow();
        System.out.println("");


    }
}
