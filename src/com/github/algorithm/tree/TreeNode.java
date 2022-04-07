package com.github.algorithm.tree;

public class TreeNode<T> {

    T val;
    TreeNode left;
    TreeNode right;

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
