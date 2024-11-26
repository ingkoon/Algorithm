package boj.boj16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj 16472 고냥이
 */
public class Main {
    static int n;
    static char[] chars;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        chars = bf.readLine().toCharArray();
        count = new int[26];
        int start = 0;
        int end = 1;
        int result = 0;

        count[chars[start] - 'a']++;

        int cnt = 1;

        while(end < chars.length && start <= end){
            if(count[chars[end] - 'a'] == 0){
                cnt++;
            }
            count[chars[end] - 'a']++;
            end++;

            while(cnt > n){
                count[chars[start]-'a']--;
                if(count[chars[start]-'a'] == 0){
                    cnt--;
                }
                start++;
            }
            result = Math.max(result, end - start);
        }
        System.out.println(result);
    }
}

/**
 * 1. 시작지점과 종료지점을 둔다.
 * 2. 하나씩 이동하면서 두 지점 사이의 알파벳 개수가 n개 이상인지 체크
 * 3. 체크 후 n개 이하라면 결과값과 비교 후 재할당
 * 3. 종료되었다면 최종적으로 몇개가 가장 많았는지 출력
 */