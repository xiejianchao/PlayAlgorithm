package com.github.algorithm.tree;

import java.util.Stack;

public class BinaryTree {

    public TreeNode root = null;

    public BinaryTree() {
        root = new TreeNode("A");
    }

    public void createBinaryTree() {
        TreeNode nodeB = new TreeNode<>("B");
        TreeNode nodeC = new TreeNode<>("C");
        TreeNode nodeD = new TreeNode<>("D");
        TreeNode nodeE = new TreeNode<>("E");
        TreeNode nodeF = new TreeNode<>("F");
        TreeNode nodeG = new TreeNode<>("G");

        root.left = nodeB;
        root.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;
    }

    /**
     * 先序遍历
     * @param head
     */
    public void preorder(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        System.out.println();
    }

    public void inorder(TreeNode head) {
        if (head == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    public void postorder(TreeNode head) {
        if (head == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);

        while (!s1.isEmpty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);

            if (curr.left != null) {
                s1.push(curr.left);
            }

            if (curr.right != null) {
                s1.push(curr.right);
            }
        }

        while (!s2.isEmpty()) {
            TreeNode curr = s2.pop();
            System.out.print(curr.val + " ");
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
    }

    public int getSize() {
        return getSize(root);
    }
    public int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getSize(node.left);
        int rightSize = getSize(node.right);
        return leftSize + rightSize + 1;
    }

}
