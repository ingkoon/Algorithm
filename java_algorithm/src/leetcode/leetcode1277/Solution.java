package leetcode.leetcode1277;

public class Solution {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }

        int result = 0;
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                result += dp[i][j];
            }
        }

        return result;
    }
}