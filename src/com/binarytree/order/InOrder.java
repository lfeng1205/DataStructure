package com.binarytree.order;

import java.util.Stack;

/**
 * Created by Feng on 2017/5/3.
 * 中序遍历
 */
public class InOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        inOrder(node);
        System.out.println();
        inOrder2(node);
    }

    //递归方式
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrder(root.left);
        }

        print(root.val);

        if (root.right != null) {
            inOrder(root.right);
        }

    }

    /*非递归形式*/
    private static void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                print(node.val);
                node = node.right;
            }
        }
    }

    public static void print(int val) {
        System.out.print(val + "\t");
    }
}
