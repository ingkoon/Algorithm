package leetcode.leetcode216;
import java.util.*;
/**
 * Definition for singly-linked list.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }

        ListNode result = stack.pop();
        ListNode cpResult = result;
        while(!stack.isEmpty()) {
            ListNode listNode = stack.pop();
            cpResult.next = listNode;
            cpResult = cpResult.next;
        }

        cpResult.next = null;
        return result;

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
