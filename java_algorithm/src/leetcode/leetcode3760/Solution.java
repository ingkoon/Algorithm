package leetcode.leetcode3760;

public class Solution {
    public int maxDistinct(String s) {
        boolean[] alpha = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] = true;
        }

        int result = 0;
        for (boolean b : alpha) {
            if (b) result++;
        }

        return result;
    }
}