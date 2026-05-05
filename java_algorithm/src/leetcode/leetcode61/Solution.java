package leetcode.leetcode61;

public class Solution {
    public static void main(String[] args) {
        ListNode node =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));


        rotateRight(node, 2);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int size = getSize(head);
        k = k % size;
        if(k == 0) return head;
        ListNode result = rotate(head, size, k);
        return result;
    }

    private static ListNode rotate(ListNode head, int size, int k) {
        int cnt = 0;
        ListNode last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = head;
        ListNode tmpHead = head;
        while(cnt < size - k - 1) {
            cnt++;
            tmpHead = tmpHead.next;
        }

        head = tmpHead.next;
        tmpHead.next = null;
        return head;
    }

    private static int getSize(ListNode listNode) {
        ListNode clone  = listNode;
        int result = 0;
        while(clone != null){
            clone = clone.next;
            result++;
        }
        return result;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}