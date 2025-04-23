package boj.boj15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for(int t = 0; t < T; t++){
            n = Integer.parseInt(bf.readLine());
            System.out.println(calc());
        }
    }

    static int calc() {
        int result = 0;
        for (int i = 0; i <= n/3; i++) {
            int first = n - (3 * i);
            result += first/2 + 1;
        }
        return result;
    }
}
