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
     * <p>
     * 1.先判断是否是首尾节点
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

    public void reversalTest2() {
        if (head == null || size == 0) {
            return;
        }

        Node prev = null;
        Node next = null;
        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
    }

    public void reversalTest() {
        if (head == null || size == 0) {
            return;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    /**
     * 单链表翻转
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

    public void reverse(Node node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            return;
        }

        Node prev = null;
        Node next;
        while (node.next != null) {
            next = node.next;//记住当前节点的下一个节点
            node.next = prev;//将当前节点的下一个节点和上一个节点交换
            prev = node;//将当前节点赋值给上一个节点
            node = next;//下一次从当前节点的下一个节点开始遍历
        }
        node.next = prev;//循环结束后，最后一个节点node置为头结点
        //重置head节点，方便直接打印输出结果
        head = node;
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
            sb.append(node.data + (node.next == null ? "" : "->"));
        }
        Log.println(sb.toString());
        sb.setLength(0);
    }
}
