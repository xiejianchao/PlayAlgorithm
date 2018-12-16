package com.github.algorithm.linked;

import com.github.algorithm.util.Log;

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

    /**
     * 思路
     *
     * 1.先判断是否是收尾节点
     * 2.然后循环整个链表，找到node.next == deleteNode
     * 3.node.next=node.next.next;判断保护node.next是否为空
     */
    public boolean delete(int data) {
        //当前链表不存在不执行删除
        if (head == null || size == 0) {
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
        } else {
            previous.next = current.next;
        }

        size--;
        return true;
    }

    /**
     * 从第2个节点到第N个节点，依次逐节点插入到第1个节点(head节点)之后，最后将第一个节点挪到新表的表尾
     */
    public void reverseLinked() {
        if (head == null || size == 0) {
            return;
        }

        Node curr = head;//为了方便理解，遍历从当前节点开始，当前节点就是初始时的head节点
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;//记住当前节点的下一个节点
            curr.next = prev;//将当前节点的下一个节点和上一个节点交换
            prev = curr;//将当前节点赋值给上一个节点
            curr = next;//下一次从当前节点的下一个节点开始遍历
        }
        head = prev;//最后将第一个节点挪到表尾
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
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
