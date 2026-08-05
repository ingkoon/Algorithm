package programmers.programmers42892;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] nodeinfo = new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] result = solution(nodeinfo);

        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Node {
        int num, x, y;
        Node left, right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodeArr = new Node[n];

        for (int i = 0; i < n; i++) {
            int num = i + 1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodeArr[i] = new Node(num, x, y);
        }
        Arrays.sort(nodeArr, (a, b) -> a.y != b.y ? b.y - a.y : a.x - b.x);
        Node root = nodeArr[0];

        for (int i = 1; i < n; i++) {
            insert(root, nodeArr[i]);
        }

        List<Integer> pre = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        preorder(root, pre);
        postorder(root, pos);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = pos.get(i);
        }
        return answer;
    }

    private static void insert(Node root, Node node) {
        Node cur = root;
        while (true) {
            if (node.x < cur.x) {
                if (cur.left == null) {
                    cur.left = node;
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    return;
                }
                cur = cur.right;
            }
        }
    }

    private static void preorder(Node node, List<Integer> pre) {
        if(node == null) {
            return;
        }
        pre.add(node.num);
        preorder(node.left, pre);
        preorder(node.right, pre);
    }

    private static void postorder(Node node, List<Integer> pos) {
        if(node == null) {
            return;
        }
        postorder(node.left, pos);
        postorder(node.right, pos);
        pos.add(node.num);
    }
}
