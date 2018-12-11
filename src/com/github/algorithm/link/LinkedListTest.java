package com.github.algorithm.link;

import com.github.algorithm.util.Log;

public class LinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList link = new SingleLinkedList();
        link.addHead(1);
        link.addHead(new Node(2));
        link.addHead(3);
        link.addHead(4);
        link.addHead(5);
        link.addHead(6);

        link.print();

        Log.println("删除节点5后的链表为：");
        link.delete(5);
        link.print();
        Log.println("删除节点5后的链表长度为：" + link.getSize());
    }
}
