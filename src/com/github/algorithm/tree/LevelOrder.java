package com.github.algorithm.tree;

import com.github.algorithm.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node20 = new TreeNode<Integer>(20);
        TreeNode<Integer> node15 = new TreeNode<Integer>(15);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);

        node20.left = node15;
        node20.right = node7;

        root.left = node9;
        root.right = node20;

        List<List<Integer>> lists = levelOrder(root);
        Log.print("res:" + lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        if (root == null) {
            return res;
        } else {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

}
