package leetcode.leetcode143;

import java.util.Stack;

public class Solution {
    public void reorderList(ListNode head) {
        ListNode fst = head;
        ListNode snd = head;

        while(snd.next != null && snd.next.next != null) {
            fst = fst.next;
            snd = snd.next.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode back = fst.next;
        while (back != null) {
            stack.push(back);
            back = back.next;
        }

        fst.next = null;
        ListNode result = head;
        while(!stack.isEmpty()) {
            ListNode tmp = result.next;
            ListNode last = stack.pop();
            result.next = last;
            last.next = tmp;
            result = tmp;
        }
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
