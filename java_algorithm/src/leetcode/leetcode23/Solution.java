package leetcode.leetcode23;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int size = 0;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });


        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            pq.offer(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            node = node.next;
            if (node == null)
                continue;
            pq.offer(node);
        }

        result = result.next;
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
