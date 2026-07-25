package programmers.programmers72413;

import java.util.*;

public class Solution {
    static List<Node>[] nodeListArr;
    static int MAX_SIZE = 20_000_001;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        nodeListArr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            nodeListArr[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int fst = fare[0];
            int snd = fare[1];
            int dist = fare[2];
            nodeListArr[fst].add(new Node(snd, dist));
            nodeListArr[snd].add(new Node(fst, dist));
        }

        int answer = MAX_SIZE;
        int[] firstDist = dijkstra(n, s);
        for (int i = 1; i <= n; i++) {
            int[] secondDist = dijkstra(n, i);
            int tmp = firstDist[i] + secondDist[a] + secondDist[b];
            answer = Math.min(answer, tmp);
        }

        return answer;
    }

    private int[] dijkstra(int n, int dep) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, MAX_SIZE);
        dist[dep] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dis));

        queue.offer(new Node(dep, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (visited[cur.des]) continue;
            visited[cur.des] = true;
            List<Node> nextList = nodeListArr[cur.des];

            for (Node nextNode : nextList) {
                int nextValue = dist[cur.des] + nextNode.dis;
                if (dist[nextNode.des] > nextValue) {
                    dist[nextNode.des] = nextValue;
                    queue.offer(new Node(nextNode.des, nextValue));
                }
            }
        }
        return dist;
    }

    static class Node {
        int des;
        int dis;

        public Node(int des, int dis) {
            this.des = des;
            this.dis = dis;
        }
    }
}
