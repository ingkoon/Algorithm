package boj.boj1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * BOJ 1927 최소 힙
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                System.out.println(queue.isEmpty() ? 0 : queue.poll());
            }else{
                queue.offer(num);
            }
        }
    }
}
