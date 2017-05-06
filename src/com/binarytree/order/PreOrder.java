package com.binarytree.order;

import java.util.Stack;

/**
 * Created by Feng on 2017/5/3.
 * 先序遍历
 */
public class PreOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        preOrder(node);
        System.out.println();
        preOrder2(node);
    }

    //递归形式
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //非递归形式，借助栈
    public static void preOrder2(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                print(root.val);
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.peek();
                stack.pop();
                root = root.right;
            }
        }
    }

    public static void print(int val) {
        System.out.print(val + "\t");
    }
}
