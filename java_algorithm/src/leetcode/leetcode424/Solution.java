package leetcode.leetcode424;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return s.length();
        }
        int start = 0;
        int end = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(start), 1);
        int max = 1;
        int size = 1;
        int result = 1;

        while (end < s.length() && start < end) {
            char endChar = s.charAt(end);
            int endCnt = map.getOrDefault(endChar, 0) + 1;
            map.put(endChar, endCnt);
            max = Math.max(max, endCnt);
            size++;

            while ((size - max) > k) {
                char startChar = s.charAt(start);
                int startCnt = map.get(startChar);
                map.put(startChar, startCnt - 1);
                size--;
                start++;
            }

            result = Math.max(result, size);
            end++;
        }
        return result;
    }
}
