package leetcode.leetcode73;

import java.util.*;

public class Solution {
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};

    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] mat = queue.poll();
            update(mat[0], mat[1], matrix);
        }
    }

    private void update(int r, int c, int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += dr[i];
                nc += dc[i];
                if (!isCheck(matrix.length, matrix[0].length, nr, nc))
                    break;
                matrix[nr][nc] = 0;
            }
        }
    }

    private boolean isCheck(int r, int c, int pr, int pc) {
        return 0 <= pr && pr < r && 0 <= pc & pc < c;
    }
}