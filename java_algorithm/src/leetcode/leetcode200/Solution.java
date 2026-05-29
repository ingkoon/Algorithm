package leetcode.leetcode200;
import java.util.*;

class Solution {
    static Queue<int[]> queue;
    static int[] dr = new int[] {0, 1, 0, -1};
    static int[] dc = new int[] {1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];

        int result = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '0'){
                    continue;
                }
                result += bfs(visited, grid, r, c, i, j);
            }
        }

        return result;
    }

    private int bfs(boolean[][] visited, char[][] grid, int r, int c, int pr, int pc) {
        if(visited[pr][pc]){
            return 0;
        }

        queue = new LinkedList<>();
        queue.offer(new int[] {pr, pc});
        visited[pr][pc] = true;
        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int cr = loc[0];
            int cc = loc[1];
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(!isCheck(r, c, nr, nc) || visited[nr][nc] || grid[nr][nc] == '0'){
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return 1;
    }

    private boolean isCheck(int r, int c, int pr, int pc) {
        return 0 <= pr && pr < r && 0 <= pc && pc < c;
    }
}