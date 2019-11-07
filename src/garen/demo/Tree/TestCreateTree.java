package garen.demo.Tree;

/**
 * @Title 实例化二叉树
 * @Author : Garen
 * @Date : 2019/11/7 21:04
 */
public class TestCreateTree {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        Node root = new Node(1);
        binTree.setRoot(root);
        Node rootL = new Node(2);
        root.setLchild(rootL);
        Node rootR = new Node(3);
        root.setRchild(rootR);

        rootL.setLchild(new Node(4));
        rootL.setRchild(new Node(5));

        rootR.setLchild(new Node(6));
        rootR.setRchild(new Node(7));


        System.out.print("前序遍历:");
        root.frontShow();
        System.out.print("\n中序遍历：");
        root.midShow();
        System.out.print("\n后序遍历：");
        root.afterShow();
    }
}
