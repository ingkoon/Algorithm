package leetcode.leetcode1514;

import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> nodeList = new ArrayList<>();
        double[] dist = new double[n];
        dist[start_node] = 1.0;

        for (int i = 0; i < n; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double succ = succProb[i];

            nodeList.get(edge[0]).add(new Node(edge[1], succ));
            nodeList.get(edge[1]).add(new Node(edge[0], succ));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));
        queue.offer(new Node(start_node, 1.0));

        while (!queue.isEmpty()) {
            Node pNode = queue.poll();
            int des = pNode.des;
            double dis = pNode.dis;
            if (des == end_node) return dis;

            if (dis < dist[des]) continue;


            for (int i = 0; i < nodeList.get(des).size(); i++) {
                Node next = nodeList.get(des).get(i);
                double nextDis = next.dis * dis;
                if (dist[next.des] < nextDis) {
                    dist[next.des] = nextDis;
                    queue.offer(new Node(next.des, nextDis));
                }
            }
        }

        return dist[end_node];
    }

    class Node {
        int des;
        double dis;

        public Node(int des, double dis) {
            this.des = des;
            this.dis = dis;
        }
    }
}