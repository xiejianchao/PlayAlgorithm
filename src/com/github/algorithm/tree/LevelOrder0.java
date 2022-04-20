package com.github.algorithm.tree;

import com.github.algorithm.data.BaseData;
import com.github.algorithm.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelOrder0 {

    public static void main(String[] args) {
        TreeNode<Integer> root = BaseData.createNode();

        int[] res = levelOrder(root);
        Log.print("res:" + res);
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add((Integer) node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
