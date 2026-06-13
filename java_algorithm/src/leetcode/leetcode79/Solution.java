package leetcode.leetcode79;

class Solution {
    static int[] dr = new int[] {1, 0, -1, 0};
    static int[] dc = new int[] {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                // 시작 글자가 일치하는 경우에만 DFS 탐색 시작
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int cr, int cc, int idx, boolean[][] visited) {
        if(idx == word.length() - 1) {
            return true;
        }
        visited[cr][cc] = true;

        for(int i = 0; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];

            if(checkWall(board.length, board[0].length, nr, nc)
                    && !visited[nr][nc]
                    && board[nr][nc] == word.charAt(idx + 1)) {

                if(dfs(board, word, nr, nc, idx + 1, visited)) {
                    return true;
                }
            }
        }
        visited[cr][cc] = false;

        return false;
    }

    private boolean checkWall(int r, int c, int pr, int pc) {
        return 0 <= pr && pr < r && 0 <= pc && pc < c;
    }
}