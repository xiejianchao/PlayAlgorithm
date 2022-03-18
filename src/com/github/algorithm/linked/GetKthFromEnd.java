package com.github.algorithm.linked;

import com.github.algorithm.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GetKthFromEnd {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        long start = System.currentTimeMillis();
        ListNode kthFromEnd2 = getKthFromEnd3(node1, 5);
        long cost = System.currentTimeMillis() - start;
        Log.print("cost:" + cost);
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 顺序查找
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode node = null;
        int n = 0;
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }
        return node;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int count = 1;
        ListNode temp = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (count == k) {
                temp = list.get(i);
                break;
            }
            count++;
        }
        return temp;
    }

}
