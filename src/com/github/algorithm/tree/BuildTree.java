package com.github.algorithm.tree;

public class BuildTree {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};

        TreeNode<Integer> treeNode = buildTree(preOrder, inOrder);
        System.out.println("treeNode:" + treeNode);
    }

    private static TreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        return build(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    /**
     * 前序遍历：{1, [2, 4, 5], [3, 6, 7]}
     * 中序遍历：{[4, 2, 5], 1, [6, 3, 7]}
     * @param preOrder
     * @param inOrder
     * @param preOrderStart
     * @param preOrderEnd
     * @param inOrderStart
     * @param inOrderEnd
     * @return
     */
    private static TreeNode<Integer> build(int[] preOrder, int[] inOrder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrder.length || inOrderStart > inOrder.length || preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) {
            return null;
        }
        //构建头结点
        int headNodeVal = preOrder[preOrderStart];
        TreeNode<Integer> node = new TreeNode<>(headNodeVal);

        int headNodeIndex = inOrderStart;
        //找到头节点在中序排序中的位置
        while (inOrder[headNodeIndex] != headNodeVal) {
            headNodeIndex++;
        }
        //获得头结点在中序排序中的位置
        headNodeIndex -= inOrderStart;

        /**
         * 头结点左子树前序排序的起始位置：前序遍历起始位置 + 1，注释中前序遍历 2 的位置
         * 头结点左子树前序排序的结束位置：前序遍历起始位置 + 中序遍历中头结点之前的元素之和，也就是 headNodeIndex
         * 头结点左子树中序排序的起始位置：中序排序的起始位置
         * 头结点左子树中序排序的结束位置：中序排序的起始位置 + headNodeIndex - 1
         */
        node.left = build(preOrder, inOrder, preOrderStart + 1, preOrderStart + headNodeIndex, inOrderStart, inOrderStart + headNodeIndex - 1);
        /**
         * 头结点右子树前序排序的起始位置：前序排序起始位置 + headNodeIndex + 1，也就是注释中前序遍历 3 的位置
         * 头结点右子树前序排序的结束位置：前序遍历的长度 preOrderEnd
         * 头结点右子树中序排序的起始位置：中序排序起始位置 + headNodeIndex + 1，也就是注释中中序遍历 6 的位置
         * 头结点右子树中序排序的结束位置：中序排序的长度 inOrderEnd
         */
        node.right = build(preOrder, inOrder, preOrderStart + headNodeIndex + 1, preOrderEnd, inOrderStart + headNodeIndex + 1, inOrderEnd);
        return node;
    }
}
