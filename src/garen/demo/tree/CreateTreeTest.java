package garen.demo.tree;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title 实例化二叉树
 * @Author : Garen
 * @Date : 2019/11/7 21:04
 */
@SuppressWarnings("unchecked")
public class CreateTreeTest {
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

        int height = tree.getHeight(root);
        System.out.println(height);
    }

    @Test
    public void Test2() {
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);//匹配所有空白字符
        String pre = tree.preOrder(root).replaceAll("\\s*", "");
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
        String pre = "ABCDEFG";
        String in = "CBAEFGD";
        BinaryTree tree = new BinaryTree(pre,in,true);
        System.out.println(tree.preOrder(tree.getRoot()));
        System.out.println(tree.inOrder(tree.getRoot()));
        System.out.println(tree.getHeight(tree.getRoot()));
        System.out.println(tree.getCount(tree.getRoot()));

    }

    @Test
    public void Test6() {
        char[] preStr = "ABC#D#EGH".toCharArray();
        BinaryTree tree = new BinaryTree(preStr);
        System.out.println(tree.preOrder(tree.getRoot()));
        System.out.println(tree.inOrder(tree.getRoot()));
        System.out.println(tree.postOrder(tree.getRoot()));
        System.out.println(tree.getHeight(tree.getRoot()));
    }

    @Test()
    public void Test7(){
        BinaryTree tree = new BinaryTree();
        String exp = "A(B(C,D),E(,F))";
        Node root = tree.createBinaryTree(exp);
        String pre = "ABCDEFG";
        String in = "CBAEFGD";
        BinaryTree new_tree = new BinaryTree(pre,in,true);
        Node copyRoot = tree.copyTree(tree.getRoot());

        BinaryTree copyTree = new BinaryTree(copyRoot);
        //判断两棵树是否相同
        System.out.println(tree.isEqual(root, new_tree.getRoot()));
        System.out.println(tree.equals(new_tree));
        System.out.println(tree.equals(copyTree));

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
    }
    @Test
    public void Test8(){
        int[] nums = {2,7,11,6};
        int target  = 9;
        int[] sum = twoSum(nums, target);
        for (int i : sum) {
            System.out.print(i+",");
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int volume = 2048;       //100000000000
        int bitMode = volume - 1; //011111111111
        int[] result = new int[volume];
        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (result[c] != 0) {
                return new int[]{result[c] - 1, i};
            }
            result[nums[i] & bitMode] = i + 1;
        }
        return null;
    }

}
