package boj.boj12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s, t;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        t = bf.readLine();
        answer = 0;
        calc(t);
        System.out.println(answer);
    }

    private static void calc(String voca) {
        if(voca.length() == s.length()){
            int result = voca.equals(s) ? 1 : 0;
            if(answer == 1){
                return;
            }
            answer = result;
            return;
        }
        if(voca.endsWith("A")){
            calc(voca.substring(0, voca.length()-1));
        }
        if(voca.startsWith("B"))
            calc(new StringBuilder(voca.substring(1)).reverse().toString());
    }
}
