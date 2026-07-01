package leetcode.leetcode102;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int idx, List<List<Integer>> result) {
        if(node == null) {
            return;
        }
        if (idx == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(idx).add(node.val);

        dfs(node.left, idx + 1, result);
        dfs(node.right, idx + 1, result);
    }

    static class TreeNode {
      TreeNode left;
      int val;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
