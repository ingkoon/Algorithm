package leetcode.leetcode572;

import leetcode.datastructure.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result = getResult(root, subRoot);
        return result;
    }

    private boolean getResult(TreeNode node, TreeNode subNode) {
        if (node == null) {
            return false;
        }

        boolean result = false;
        if (node.val == subNode.val) {
            result = dfs(node, subNode);
        }

        return result || getResult(node.left, subNode) || getResult(node.right, subNode);
    }

    private boolean dfs(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }

        if (node == null || subNode == null) {
            return false;
        }
        if (node.val != subNode.val) {
            return false;
        }

        return dfs(node.left, subNode.left) && dfs(node.right, subNode.right);
    }
}
