package boj.boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Node[] towers;
    static int[] result;
    static Stack<Node> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        stack = new Stack<>();
        towers = new Node[n];
        result = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            towers[i] = new Node(i, input);
        }

        for (int i = 0; i < n; i++) {
            Node node = towers[i];
            while(!stack.isEmpty()){
                if(stack.peek().num < node.num){
                    stack.pop();
                    continue;
                }
                result[i] = stack.peek().idx + 1;
                stack.push(node);
                break;
            }

            if(stack.isEmpty()) {
                result[i] = 0;
                stack.push(towers[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class Node{
        int idx;
        int num;
        public Node(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}