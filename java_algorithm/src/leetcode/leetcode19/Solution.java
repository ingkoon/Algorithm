package leetcode.leetcode19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1.next == head && p1 != p2) {
            return head.next;
        } else if (p1.next == head) {
            return null;
        }

        ListNode tmp = p1.next;
        if (tmp.next == null) {
            p1.next = null;
        } else {
            p1.next = tmp.next;
        }

        return head;
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