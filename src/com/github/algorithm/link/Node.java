package com.github.algorithm.link;

public class Node {

    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
