package leetcode.leetcode417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static int[] dr = new int[] {0, 1, 0, -1};
    static int[] dc = new int[] {1, 0, -1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] isVisitedPacific = new boolean[r][c];
        boolean[][] isVisitedAtlantic = new boolean[r][c];

        for(int i = 0; i < r; i++){
            bfs(isVisitedPacific, heights, r, c, i, 0);
            bfs(isVisitedAtlantic, heights, r, c, i, c-1);
        }

        for(int i = 0; i < c; i++) {
            bfs(isVisitedPacific, heights, r, c, 0, i);
            bfs(isVisitedAtlantic, heights, r, c, r-1, i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(isVisitedPacific[i][j] && isVisitedAtlantic[i][j]){
                    List<Integer> value = new ArrayList<>();
                    value.add(i);
                    value.add(j);
                    result.add(value);
                }
            }
        }
        return result;
    }

    private void bfs(boolean[][] isVisited, int[][] heights, int r, int c, int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startR, startC});
        isVisited[startR][startC] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(!isCheck(r, c, nr, nc) || isVisited[nr][nc] || heights[nr][nc] < heights[cr][cc])
                    continue;
                isVisited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    private boolean isCheck(int r, int c, int pr, int pc) {
        return  0 <= pr && pr < r && 0 <= pc && pc < c;
    }
}