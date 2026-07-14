package leetcode.leetcode120;

import java.util.List;
import java.util.Arrays;

public class Solution {
    static final int MAX_SIZE = 10001;
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(row - 1).size();
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], MAX_SIZE);
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            List<Integer> beforeList = triangle.get(i - 1);
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);
            dp[i][list.size() - 1] = dp[i - 1][beforeList.size() - 1] + list.get(list.size() - 1);
            for (int j = 1; j < list.size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + list.get(j), dp[i - 1][j] + list.get(j));
            }
        }

        int result = MAX_SIZE;
        for (int i = 0; i < column; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }
        return result;
    }
}
