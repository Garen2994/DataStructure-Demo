package garen.demo.Tree;
import org.junit.jupiter.api.Test;
/**
 * @Title 实例化二叉树
 * @Author : Garen
 * @Date : 2019/11/7 21:04
 */
public class TestCreateTree {
    @Test
    public void createTest(){
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


        System.out.print("Pre-order: ");
        root.frontShow();
        System.out.print("\nMedium-order: ");
        root.midShow();
        System.out.print("\nPost-order:　");
        root.afterShow();
    }
}
