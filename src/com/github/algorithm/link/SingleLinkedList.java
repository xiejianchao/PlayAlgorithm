package com.github.algorithm.link;

import com.github.algorithm.util.Util;

public class SingleLinkedList {

    private Node head;
    private int size;

    public void addHead(int node) {
        Node newNode = new Node(node);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    /**
     * 思路
     *
     * 1.先判断是否是收尾节点
     * 2.然后循环整个链表，找到node.next == deleteNode
     * 3.node.next=node.next.next;判断保护node.next是否为空
     */
    public boolean delete(int data) {
        //当前不存在不执行删除
        if (size == 0 || head == null) {
            return false;
        }

        Node previous = head;
        Node current = head;

        while (current.data != data) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else {
                Util.println("要删除的节点不存在当前链表中");
                return false;
            }
        }

        //删除的是头结点
        if (current == head) {
            head = current.next;
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(head.data + "->");
        Node tempHead = head;
        while (tempHead.next != null) {
            Node node = tempHead.next;
            tempHead = node;
            if (node != null) {
                sb.append(node.data + (node.next == null ? "" : "->"));
            }
        }
        System.out.println(sb.toString());
        sb.setLength(0);
    }
}
