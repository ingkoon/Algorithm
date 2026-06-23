package leetcode.leetcode124;

import leetcode.datastructure.TreeNode;

public class Solution {
    static int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftVal = Math.max(0, dfs(node.left));
        int rightVal = Math.max(0, dfs(node.right));

        int currentTotal = node.val + leftVal + rightVal;
        result = Math.max(result, currentTotal);
        return node.val + Math.max(leftVal, rightVal);
    }
}