package boj.boj2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = getResult();
        StringBuilder sb = new StringBuilder().append(sum[0])
                .append(" ")
                .append(sum[1]);
        System.out.println(sb);
    }

    static int[] getResult(){
        int left = 0;
        int right = n - 1;
        int result = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(Math.abs(sum) <= result){
                result = Math.abs(sum);
                n1 = left;
                n2 = right;
            }
            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
        return new int[] {numbers[n1], numbers[n2]};
    }
}