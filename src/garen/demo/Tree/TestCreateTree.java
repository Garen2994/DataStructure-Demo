package garen.demo.Tree;

import org.junit.jupiter.api.Test;

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
        System.out.println(tree.preOrderRecursion(root));
        System.out.println("=======in-order=========");
        System.out.println(tree.inOrderRecursion(root));
        System.out.println("=======post-order=======");
        System.out.println(tree.postOrderRecursion(root));
        System.out.println("=======非递归pre-order======");
        System.out.println(tree.preOrder(root));
        System.out.println("=======非递归in-order=======");
        System.out.println(tree.inOrder(root));
        System.out.println("=======非递归post-order=====");
        System.out.println(tree.postOrder(root));
        System.out.println("=======层序遍历=======");
        System.out.println(tree.levelOrder(root));
    }

    @Test
    public void Test2() {
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);
        String pre = tree.preOrder(root).replaceAll("\\s*", "");   //匹配所有空白字符
        String in = tree.inOrder(root).replaceAll("\\s*", "");
        System.out.println(pre);
        System.out.println(in);
        System.out.println(tree.levelOrder(tree.createTreeByPreAndIn(pre, in)));
    }

    @Test
    public void Test3() {
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);
        String post = tree.postOrder(root).replaceAll("\\s*", "");
        String in = tree.inOrder(root).replaceAll("\\s*", "");
        System.out.println(tree.levelOrder(tree.createTreeByPostAndIn(post, in)));
    }

    /**
     * @description copy树测试类
     */
    @Test
    public void Test4() {
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);
        Node node = tree.copyTree(root);
        BinaryTree new_tree = new BinaryTree(node);
        System.out.println(new_tree.preOrder(node));
    }

    @Test
    public void Test5() {
        String pre = "ABCDEF";
        String in = "CBAEFD";
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTreeByPreAndIn(pre, in);
        System.out.println(tree.printTreeInExpression(root));
    }

    @Test
    public void Test6() {
        char[] preStr = "ABC#D#E".toCharArray();
        BinaryTree tree = new BinaryTree();
        Node temp = new Node(null);
        System.out.println(tree.preOrder(tree.createTreeByPreStr(preStr, temp)));
    }
}
