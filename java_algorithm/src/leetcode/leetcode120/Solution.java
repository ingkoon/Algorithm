package leetcode.leetcode120;

import java.util.List;

public class Solution {
    static final int MAX_SIZE = 10001;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }
}
