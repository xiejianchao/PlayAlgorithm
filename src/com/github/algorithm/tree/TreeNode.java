package com.github.algorithm.tree;

public class TreeNode<T> {

    T value;
    TreeNode left;
    TreeNode right;

    public TreeNode(T value) {
        this.value = value;
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
