package com.binarytree.order;

import java.util.Stack;

/**
 * Created by Feng on 2017/5/3.
 * 后序遍历
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        postOrder(node);
        System.out.println();
        postOrder2(node);
    }

    /**
     * 递归形式
     *
     * @param root
     */
    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrder(root.left);
        }

        if (root.right != null) {
            postOrder(root.right);
        }

        print(root.val);

    }

    /**
     * 非递归形式
     *
     * @param root
     */
    private static void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        //每次循环最后访问的节点
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {

            //左子树入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            //查看当前栈顶元素
            node = stack.peek();

            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                print(node.val);
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则遍历右子树
                node = node.right;
            }
        }

    }

    private static void print(int val) {
        System.out.print(val + "\t");
    }
}
