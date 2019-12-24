package garen.demo.Tree;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @Title 实例化二叉树
 * @Author : Garen
 * @Date : 2019/11/7 21:04
 */
@SuppressWarnings("unchecked")
public class TestCreateTree {
    @Test
    public void createTest() {
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

    }

    @Test
    public void Test1() {
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);
        System.out.println("=======pre-order========");
        tree.preOrderTraverse(root);
        System.out.println();
        System.out.println("=======in-order========");
        tree.inOrderTraverse(root);
        System.out.println();
        System.out.println("=======post-order=======");
        tree.postOrderTraverse(root);
        System.out.println();
        System.out.println("=======非递归pre-order=======");
        tree.preOrder(root);
        System.out.println();
        System.out.println("=======非递归in-order=======");
        tree.inOrder(root);
        System.out.println();
        System.out.println("=======非递归post-order=======");
        tree.postOrder(root);
        System.out.println();
    }
}
