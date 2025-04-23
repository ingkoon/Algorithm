package boj.boj13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, k, SIZE = 100_001;
    static boolean[] board;
    static PriorityQueue<Loc> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new boolean[SIZE];
        System.out.println(play());
    }

    static int play() {
        int result = Integer.MAX_VALUE;
        queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        queue.offer(new Loc(n, 0));
        while (!queue.isEmpty()) {
            Loc loc = queue.poll();
            board[loc.loc] = true;
            if(loc.loc == k){
                result = Math.min(result, loc.count);
            }

            if(loc.loc*2 < SIZE && !board[loc.loc * 2]) {
                queue.offer(new Loc(loc.loc*2, loc.count));
            }
            if(loc.loc+1 < SIZE && !board[loc.loc + 1]) {
                queue.offer(new Loc(loc.loc+1, loc.count+1));
            }
            if(loc.loc-1 >= 0 && !board[loc.loc - 1]) {
                queue.offer(new Loc(loc.loc-1, loc.count + 1));
            }
        }

        return result;
    }

    static class Loc {
        int loc;
        int count;

        public Loc(int loc, int count) {
            this.loc = loc;
            this.count = count;
        }
    }
}
