package boj.boj11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        int result = 0;
        for (int i = n-1; i >= 0; i--) {
            if(k / coins[i] == 0) {
                continue;
            }
            result += k / coins[i];
            k = k % coins[i];
        }

        System.out.println(result);
    }
}
