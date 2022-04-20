package com.github.algorithm.data;

import com.github.algorithm.tree.TreeNode;

public class BaseData {

    public static final int[] ARR = {11, 29, 25, 9, 21, 18, 7, 16};

    public static final int[] ARR_SORTED_1 = {3, 6, 15, 18, 19, 22, 25, 28};
    public static final int[] ARR_SORTED_2 = {12, 16, 30, 32, 33, 36, 38, 51, 53};

    public static final int[] ARR_SORTED_3 = {1, 2, 3};
    public static final int[] ARR_SORTED_4 = {2, 5, 6};

    public static TreeNode<Integer> createNode() {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node20 = new TreeNode<Integer>(20);
        TreeNode<Integer> node15 = new TreeNode<Integer>(15);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);

        node20.left = node15;
        node20.right = node7;

        root.left = node9;
        root.right = node20;
        return root;
    }

}
