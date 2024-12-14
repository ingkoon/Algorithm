package boj.boj10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int n, x;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num >= x){
                continue;
            }
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
