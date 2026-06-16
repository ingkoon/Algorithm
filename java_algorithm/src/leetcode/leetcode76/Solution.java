package leetcode.leetcode76;

import java.util.Map;
import java.util.HashMap;


public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<String, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int start = 0;
        int matchCount = 0;
        int expectedMatch = tMap.size();

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        char[] sChar = s.toCharArray();

        for (int end = 0; end < s.length(); end++) {
            char cur = sChar[end];

            if (tMap.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);

                if (window.get(cur).equals(tMap.get(cur))) {
                    matchCount++;
                }
            }

            while (matchCount == expectedMatch) {
                int currentLen = end - start + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = start;
                }

                char leftChar = sChar[start];
                if (tMap.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(tMap.get(leftChar))) {
                        matchCount--;
                    }
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}