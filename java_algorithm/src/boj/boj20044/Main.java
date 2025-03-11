package boj.boj20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, SIZE, answer = Integer.MAX_VALUE;
    static int[] students;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        SIZE = n * 2;
        students = new int[SIZE];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < SIZE; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);
        for (int i = 0; i < n; i++) {
            int pair = students[i] + students[SIZE - i - 1];
            answer = Math.min(answer, pair);
        }

        System.out.println(answer);
    }
}
