package com.github.algorithm.linked;

import com.github.algorithm.util.Log;

public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList link = new SingleLinkedList();
        link.addHead(5);
        link.addHead(4);
        link.addHead(3);
        link.addHead(new Node(2));
        link.addHead(1);

        Log.println("初始链表为：");
        link.print();
//
//        Log.println("删除节点5后的链表为：");
//        link.delete(5);
//        link.print();
//        Log.println("删除节点5后的链表长度为：" + link.getSize());

        link.reverseLinked();
        Log.println("链表翻转后为：");
        link.print();
//        link.reverseLinked();
//        Log.println("第二次链表翻转后为：");
//        link.print();
    }
}
