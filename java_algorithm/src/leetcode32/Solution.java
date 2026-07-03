package leetcode32;

public class Solution {
    public int longestValidParentheses(String s) {
        int size = s.length();
        int[] dp = new int[size];

        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '(') {
                continue;
            }
            if(i - 1 >= 0 && s.charAt(i-1) == '(') {
                dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
            } else if (i > 0 && (i - dp[i-1] - 1) >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                int prevIdx = i - dp[i - 1] - 2;
                dp[i] = dp[i-1] + 2 + (prevIdx >= 0 ? dp[prevIdx] : 0);
            }
        }

        int result = 0;
        for(int i : dp) {
            result = Math.max(result, i);
        }
        return result;
    }
}