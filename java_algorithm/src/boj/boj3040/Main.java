package boj.boj3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 3040 백설공주와 일곱 난쟁이
 */
public class Main {
    private static final int DWARF_COUNT = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[DWARF_COUNT];
        boolean[] check = new boolean[DWARF_COUNT];

        int sum = 0;
        boolean flag = false;

        for (int i = 0; i < DWARF_COUNT; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < DWARF_COUNT-1; i++) {
           check[i] = true;
            for (int j = i+1; j < DWARF_COUNT; j++) {
                check[j] = true;
                int result = sum - (arr[i] + arr[j]);
                if(result == 100) {
                    flag = true;
                    break;
                }
                check[j] = false;
            }
            if(flag){
                break;
            }
            check[i] = false;
        }

        for (int i = 0; i < DWARF_COUNT; i++) {
            if(check[i]) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
