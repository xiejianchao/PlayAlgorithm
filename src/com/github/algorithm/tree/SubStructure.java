package com.github.algorithm.tree;

import com.github.algorithm.util.Log;

public class SubStructure {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode1 = new TreeNode<>(1);
        TreeNode<Integer> treeNode2 = new TreeNode<>(2);
        TreeNode<Integer> treeNode3 = new TreeNode<>(3);
        TreeNode<Integer> treeNode4 = new TreeNode<>(4);
        TreeNode<Integer> treeNode5 = new TreeNode<>(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode<Integer> treeNodeSub = new TreeNode<>(5);

        boolean subStructure = isSubStructure(treeNode1, treeNodeSub);
        Log.print("res:" + subStructure);
    }

    public static boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        if (isSame(a, b)){
            return true;
        }
        return isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    public static boolean isSame(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

}
