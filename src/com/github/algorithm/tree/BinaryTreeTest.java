package com.github.algorithm.tree;

public class BinaryTreeTest {

    public static void main(String[] arg1s) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        int height = binaryTree.getHeight();
        int size = binaryTree.getSize();

        System.out.println("binary height:" + height + " , size:" + size);

        System.out.println("前序遍历：");
        binaryTree.preorder(binaryTree.root);
        System.out.println("中序序遍历：");
        binaryTree.inorder(binaryTree.root);
        System.out.println("后序遍历：");
        binaryTree.postorder(binaryTree.root);
    }

}
