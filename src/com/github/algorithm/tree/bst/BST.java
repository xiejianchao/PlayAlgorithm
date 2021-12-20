package com.github.algorithm.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @param <Key>
 * @param <Value>
 */
@SuppressWarnings("all")
public class BST<Key extends Comparable, Value> {

    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    private Node root;  // 根节点
    private int count;  // 树种的节点个数

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public Node insert(Key key, Value value) {
        return insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private boolean contains(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void levelSort() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public Node minimum(Node node) {
        assert node != null;
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public Node maxinum(Node node) {
        assert node != null;
        if (node.right == null) {
            return node;
        }
        return maxinum(node.right);
    }

    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            count--;
            return leftNode;
        }
        node.left = removeMax(node.right);
        return node;
    }

    public Node remove(Node node, Key key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else {
            //待删除的左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            //待删除的右子树为空时
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            //待删除的左子树和右子树都存在的情况
            Node successor = new Node(minimum(node.right));
            successor.right = removeMin(node.right);
            successor.left = node.left;
            count++;
            return successor;
        }
        return null;
    }

}
