package boj.boj20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int T, k;
    static String w;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            w = bf.readLine();
            k = Integer.parseInt(bf.readLine());
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }
            int[] result = calculateString();
            if (result == null) {
                System.out.println("-1");
            } else {
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    static int[] calculateString() {
        map = new HashMap<>();
        char[] chars = w.toCharArray();
        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int[] result = new int[]{Integer.MAX_VALUE, 0};
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) < k) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    count++;
                }
                if (count == k) {
                    result[0] = Math.min(result[0], j - i + 1);
                    result[1] = Math.max(result[1], j - i + 1);
                    break;
                }
            }
        }
        return (result[0] == Integer.MAX_VALUE || result[1] == 0) ? null : result;
    }
}