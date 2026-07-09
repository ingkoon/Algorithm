package leetcode.leetcode1976;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    static final int MODULO = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE / 2);
        dist[0] = 0;
        ways[0] = 1;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Node(road[1], road[2]));
            adj.get(road[1]).add(new Node(road[0], road[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dis, o2.dis));
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currNum = curr.des;
            long currDis = curr.dis;

            if (currDis > dist[currNum]) continue;

            for (Node nextNode : adj.get(currNum)) {
                int nextNum = nextNode.des;
                long newDist = currDis + nextNode.dis;

                if (newDist < dist[nextNum]) {
                    dist[nextNum] = newDist;
                    ways[nextNum] = ways[currNum];
                    pq.offer(new Node(nextNum, newDist));
                }

                else if (newDist == dist[nextNum]) {
                    ways[nextNum] = (ways[nextNum] + ways[currNum]) % MODULO;
                }
            }
        }

        return (int) ways[n - 1];
    }

    static class Node {
        int des;
        long dis;

        public Node(int des, long dis) {
            this.des = des;
            this.dis = dis;
        }
    }
}