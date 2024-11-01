package boj.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * BOJ 11279 최대 힙
 */
public class Main {
    private static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(bf.readLine());
            if(num == 0){
                System.out.println(queue.isEmpty() ? 0 : queue.poll());
            }
            else{
                queue.offer(num);
            }
        }
    }
}