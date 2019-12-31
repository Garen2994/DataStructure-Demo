package garen.demo.tree;

import java.util.LinkedList;

/**
 * @Title : 二叉树(非线性结构)的构建与相关操作
 * @Description :
 * - 以广义表形式的字符串构建二叉树：'()'前表示根结点，括号中左右子树用逗号隔开，逗号不能省略
 * - 二叉树的层次/广序遍历算法
 * - 二叉树的前序、中序、后序遍历的递归和非递归算法(对每个节点而言，三种遍历方式都需要遍历该结点三次，三者唯一区别在于该结点的访问时机)
 * - 根据二叉树的前序、中序或中序、后序遍历结果构建二叉树
 * - 二叉树的高度
 * - 二叉树的结点总数
 * - 根据树的根结点复制一颗二叉树
 * - 获取二叉树的根结点，孩子节点
 * - 打印二叉树
 * - 判断两颗二叉树是否相等
 * @Author : Garen
 * @Date : 2019/12/23 15:57
 */
@SuppressWarnings("unchecked")
public class BinaryTree<E> {
    private Node<E> root;   //二叉树根结点

    /**
     * @param
     * @description 无参构造函数
     */

    public BinaryTree() {
        super();
    }

    /**
     * @param root
     * @description 以根节点为参数的构造方法
     */
    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Node<E> getRoot() {
        return root;
    }

    /**
     * @param exp
     * @description 根据广义表表达式建立二叉树 借助栈
     */
    public Node<E> createBinaryTree(String exp) {  //String exp为广义表表达式
        LinkedList<Node<E>> stack = new LinkedList<>();
        Node<E> node = null;
        Node<E> parent = null;
        Node<E> temp = null;
        boolean flag = false; //true 左孩子  false 右孩子

        System.out.println("广义表表达式为:" + exp);
        if (exp.length() == 0 || exp.isEmpty()) {
            return null;
        }
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '(':
                    stack.push(temp);
                    flag = true;
                    break;
                case ')':
                    stack.pop();
                    break;
                case ',':
                    flag = false;
                    break;
                default:
                    node = new Node(c);
                    break;
            }
            if (root == null)
                root = node;   //第一个读入的结点为根节点
            if (!stack.isEmpty()) {   //栈不为空
                if (node != null) {
                    parent = stack.peek();   //栈顶元素作为父结点
                    if (flag)   //以父结点为根 链入孩子结点
                        parent.setLchild(node);
                    else
                        parent.setRchild(node);
                }

            }
            temp = node; //将非空的结点准备压入栈中
            node = null;
        }
        return root;
    }

    /**
     * @description order by level ---use a queue
     */
    public String levelOrder(Node<E> root) {
        StringBuilder string = new StringBuilder();
        LinkedList<Node<E>> queue = new LinkedList<>();
        if (root == null)
            return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            string.append(node.getData() + "\t");
            if (node.getLchild() != null)
                queue.add(node.getLchild());
            if (node.getRchild() != null)
                queue.add(node.getRchild());
        }
        return string.toString();
    }

    /**
     * @param root
     * @description pre-order recursion traverse
     */
    public String preOrderRecursion(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root != null) {
            string.append(root.getData() + "\t");
            string.append(preOrderRecursion(root.getLchild()));
            string.append(preOrderRecursion(root.getRchild()));
        }
        return string.toString();
    }

    /**
     * @param root
     * @description pre-order non-recursion traverse(iteration) --- use a stack
     */
    public String preOrder(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root != null) {
            LinkedList<Node> stack = new LinkedList<>();   //栈用来存访问但未输出的结点
            Node node = root;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    string.append(node.getData() + "\t");
                    stack.push(node);
                    node = node.getLchild();
                } else {
                    node = stack.pop();
                    node = node.getRchild();
                }
            }
        }
        return string.toString();
    }

    /**
     * @param root
     * @description in-order recursion traverse
     */
    public String inOrderRecursion(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root != null) {
            string.append(inOrderRecursion(root.getLchild()));
            string.append(root.getData() + "\t");
            string.append(inOrderRecursion(root.getRchild()));
        }
        return string.toString();
    }

    /**
     * @param root
     * @description in-order non-recursion traverse
     */
    public String inOrder(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root == null)
            return null;
        LinkedList<Node> stack = new LinkedList<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLchild();
            } else {
                node = stack.pop();
                string.append(node.getData() + "\t");
                node = node.getRchild();
            }
        }
        return string.toString();
    }

    /**
     * @param root
     * @description post-order recursion traverse
     */
    public String postOrderRecursion(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root != null) {
            string.append(postOrderRecursion(root.getLchild()));
            string.append(postOrderRecursion(root.getRchild()));
            string.append(root.getData() + "\t");
        }
        return string.toString();
    }

    /**
     * @param root
     * @description post-order non-recursion traverse
     */
    public String postOrder(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root == null)
            return null;
        LinkedList<Node<E>> stack = new LinkedList<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node.setFirst(true);  // 第一次被访问记作true
                node = node.getLchild();
            } else {   //node == null
                node = stack.pop();
                if (node.isFirst()) {
                    node.setFirst(false);   //第二次访问记作false
                    stack.push(node);
                    node = node.getRchild();
                } else {   //进行第三次访问,输出
                    string.append(node.getData() + "\t");
                    node = null;
                }
            }
        }
        return string.toString();
    }

    /**
     * @param pre
     * @param in
     * @return
     * @description 根据前序和中序遍历结果确定二叉树
     */
    public Node<E> createTreeByPreAndIn(String pre, String in) {
        if (!pre.isEmpty()) {
            Node<E> root = new Node(pre.charAt(0));
            int index = in.indexOf(pre.charAt(0));
            root.setLchild(createTreeByPreAndIn(pre.substring(1, index + 1), in.substring(0, index)));
            root.setRchild(createTreeByPreAndIn(pre.substring(index + 1, pre.length()), in.substring(index + 1,
                    in.length())));
            return root;
        }
        return null;
    }

    public Node<E> createTreeByPostAndIn(String post, String in) {
        if (!post.isEmpty()) {
            Node<E> root = new Node(post.charAt(post.length() - 1));
            int index = in.indexOf(post.charAt(post.length() - 1));
            root.setLchild(createTreeByPostAndIn(post.substring(0, index), in.substring(0, index)));
            root.setRchild(createTreeByPostAndIn(post.substring(index, post.length() - 1), in.substring(index + 1,
                    in.length())));
            return root;
        }
        return null;
    }

    private int index = 0;

    public Node<E> createTreeByPreStr(char[] preStr, Node temp) {

        if (index < preStr.length) {
            char c = preStr[index++];
            if (c != '#') {
                Node<E> node = new Node(c);
                node.setLchild(createTreeByPreStr(preStr, node));
                node.setRchild(createTreeByPreStr(preStr, node));
                return node;
            }
            return null;
        }
        return null;
    }

    /**
     * @description 复制一棵二叉树
     * @param root 根
     * @return
     */
    public Node<E> copyTree(Node<E> root) {
        if (root == null) {
            return null;
        }
        Node node = new Node<E>(null);
        node.setData(root.getData());
        node.setLchild(copyTree(root.getLchild()));
        node.setRchild(copyTree(root.getRchild()));

        return node;
    }

    /**
     * @param root 根
     * @return 序列
     * @description 以广义表表达式形式打印二叉树
     */
    public String printTreeInExpression(Node<E> root) {
        StringBuilder string = new StringBuilder();
        if (root != null) {
            string.append(root.getData());
            if (root.getLchild() != null || root.getRchild() != null) {
                string.append('(');
                string.append(printTreeInExpression(root.getLchild()));
                string.append(',');
                string.append(printTreeInExpression(root.getRchild()));
                string.append(')');
            }
        }
        return string.toString();
    }
}

