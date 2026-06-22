package leetcode.leetcode5;

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String OddPalindromeString = getPalindromeString(s, i, i);
            String EvenPalindromeString = getPalindromeString(s, i, i + 1);
            String palindromeString = OddPalindromeString.length() > EvenPalindromeString.length() ? OddPalindromeString : EvenPalindromeString;
            if (result.length() < palindromeString.length()) {
                result = palindromeString;
            }
        }
        return result;
    }

    private String getPalindromeString(String s, int left, int right) {
        int start = left;
        int end = right;
        while (0 <= start && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }
}