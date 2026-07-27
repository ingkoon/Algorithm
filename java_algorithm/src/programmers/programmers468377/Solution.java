package programmers.programmers468377;

import java.util.*;

public class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int m = n - 1; // 힌트 번들은 n-1까지만 판매
        int size = n - 1; // 힌트가 최대값일경우 조절을해야한다.

        int[] price = new int[m];
        int[][] tickets = new int[m][n];
        for(int i = 0; i < m; i++) {
            price[i] = hint[i][0];
            for(int j = 1; j < hint[i].length; j++) {
                tickets[i][hint[i][j] - 1]++;
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int mask = 0; mask < (1 << m); mask++) { // 모든 경우의 수를 조회한다.
            int total = 0;
            int[] have = new int[n]; // 현재 단계에서 힌트의 개수를 저장한다.

            for(int i = 0; i < m; i++) { // n번째 위치의 힌트 여부를 검사하기 위한 반복문
                if((mask & (1 << i)) == 0) { // i번째 위치의 힌트가 구매하지 않은 힌트일 경우 패스한다.
                    continue;
                }
                total += price[i]; // 힌트 번들 구매 가격을 더한다.
                for(int j = 0; j < n; j++) {
                    have[j] += tickets[i][j]; // 해당 위치의 힌트 더한다.
                }
            }

            for(int i = 0; i < n; i++) {
                total += cost[i][Math.min(have[i], size)]; // 해당 케이스에 대해서 총 가격을 구한다.
            }

            answer = Math.min(answer, total);
        }
        return answer;
    }
}