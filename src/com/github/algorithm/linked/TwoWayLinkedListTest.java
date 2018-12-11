package com.github.algorithm.linked;

import com.github.algorithm.util.Log;

public class TwoWayLinkedListTest {

    public static void main(String[] args) {
        TwoWayLinkedList link = new TwoWayLinkedList();
        link.addHead(1);
        link.addHead(new Node(2));
        link.addHead(3);
        link.addHead(4);
        link.addHead(5);
        link.addHead(6);
        link.addHead(7);

        link.addTail(100);

        Log.print("当前的链表为：");
        link.print();

        Log.print("删除节点5后的链表为：");
        link.delete(1);
        link.print();
        Log.println("删除节点5后的链表长度为：" + link.getSize());

        Log.println("删除尾节点后的链表为：");
        link.deleteTail();
        link.print();
    }
}
