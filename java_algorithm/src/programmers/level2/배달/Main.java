package programmers.level2.배달;
import java.util.*;

public class Main {
    static int n, INF = Integer.MAX_VALUE;
    static List<Node>[] board;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) {
        int result = solution(5, new int[][]{{1, 2, 1}, {2, 3, 1}, {3, 4, 1}, {4, 5, 1}, {1, 5, 10}}, 3);
        System.out.println(result);
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        n = N;

        board = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            board[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];
        dist = new int[n+1];
        init();

        for(int i = 0; i < road.length; i++) {
            int[] r = road[i];
            int a = r[0];
            int b = r[1];
            int c = r[2];
            board[a].add(new Node(b, c));
            board[b].add(new Node(a, c));
        }

        dijkstra(1);

        for(int d : dist){
            if(d <= K) answer ++;
        }
        return answer;
    }

    private static void init(){
        Arrays.fill(dist, INF);
    }

    public static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node currentNode = pq.poll();

            int cIdx = currentNode.des;
            int cCost = currentNode.cost;

            if(visited[cIdx]) continue;

            visited[cIdx] = true;
            for(Node nNode : board[cIdx]){
                int nIdx = nNode.des;
                int nCost = nNode.cost;
                if(dist[nIdx] > dist[cIdx] + nCost) {
                    dist[nIdx] = dist[cIdx] + nCost;
                    pq.offer(new Node(nIdx, dist[nIdx]));
                }
            }
        }
    }

    static class Node {
        int des;
        int cost;

        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }
}