package boj.boj2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int fiveKgs = n / 5;
        int threeKgs = 0;
        int spareSugars = n % 5;
        while (spareSugars % 3 != 0) {
            if(fiveKgs < 0){
                break;
            }
            fiveKgs--;
            spareSugars += 5;
        }
        if(fiveKgs < 0 && spareSugars != 0){
            System.out.println(-1);
        }else{
            threeKgs = spareSugars / 3;
            System.out.println(fiveKgs + threeKgs);
        }
    }
}
