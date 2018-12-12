package com.github.algorithm.linked;

import com.github.algorithm.util.Log;

public class TwoWayLinkedList {

    private Node head;
    private Node tail;
    private int size;

    /**
     * 添加头节点
     */
    public void addHead(int node) {
        Node newNode = new Node(node);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * 添加头节点
     */
    public void addHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 添加尾节点
     */
    public void addTail(int data) {
        Node newNode = new Node(data);
        if (head == null && size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 删除尾节点
     */
    public void deleteTail() {
        if (head == null || tail == null || size == 0) {
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    /**
     * 直接删除头节点
     */
    public boolean deleteHead() {
        //如果是空链表，则返回
        if (head == null || tail == null || size == 0) {
            return false;
        }
        //如果链表只有一个节点，直接将head和tail节点设置为null
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        //节点数大于1
        head = head.next;
        head.prev = null;
        size--;
        return true;
    }

    /**
     * 思路
     * 1.先判断是否是收尾节点
     * 2.然后循环整个链表，找到node.next == deleteNode
     * 3.node.next=node.next.next;判断保护node.next是否为空
     */
    public boolean delete(int data) {
        //当前链表不存在不执行删除
        if (head == null || tail == null || size == 0) {
            return false;
        }

        Node previous = head;
        Node current = head;

        while (current.data != data) {
            if (current.next != null) {
                previous = current;
                current = current.next;
            } else {
                Log.println("要删除的节点不存在当前链表中");
                return false;
            }
        }

        //删除的是头结点
        if (current == head) {
            head = current.next;
            head.prev = null;
        } else {
            previous.next = current.next;
            current.next.prev = previous;
        }

        size--;
        return true;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int size() {
        return size;
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
        Log.println(sb.toString());
        sb.setLength(0);
    }
}
