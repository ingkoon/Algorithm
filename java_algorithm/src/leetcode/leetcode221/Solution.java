package leetcode.leetcode221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];
        int maxSize = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    }

                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize * maxSize;
    }
}