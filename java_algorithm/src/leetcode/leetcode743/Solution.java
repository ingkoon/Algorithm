package leetcode.leetcode743;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Node>[] lists = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        final int INF = 10000001;
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            lists[time[0]].add(new Node(time[1], time[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
        pq.offer(new Node(k, 0));
        while (!pq.isEmpty()) {
            Node pNode = pq.poll();
            visited[pNode.des] = true;
            List<Node> list = lists[pNode.des];
            for (Node next : list) {
                if (visited[next.des])
                    continue;
                int nextVal = pNode.dis + next.dis;
                if (dist[next.des] > nextVal) {
                    dist[next.des] = nextVal;
                    pq.offer(new Node(next.des, nextVal));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }
            result = Math.max(result, dist[i]);
        }
        return result;
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