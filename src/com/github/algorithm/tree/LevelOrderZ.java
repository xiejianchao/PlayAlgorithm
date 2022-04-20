package com.github.algorithm.tree;

import com.github.algorithm.util.Log;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class LevelOrderZ {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = null;

        node3.left = null;
        node3.right = node5;


        LinkedList<Integer> levelList = new LinkedList<>();
        levelList.add(1);
        levelList.add(2);
        levelList.addLast(3);
        levelList.addFirst(4);

        List<List<Integer>> lists = levelOrderZ(root);
        List<List<Integer>> lists2 = levelOrderZ2(root);
        Log.print("res:" + lists);
    }

    public static List<List<Integer>> levelOrderZ2(TreeNode<Integer> root) {
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
            if (res.size() % 2 != 0) {
                Collections.reverse(temp);
            }
            res.add(temp);
        }
        return res;
    }

    public static List<List<Integer>> levelOrderZ(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (res.size() % 2 == 0) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(levelList);
        }
        return res;
    }

}
