package leetcode.leetcode3;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int end = 1;
        int result = 0;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(start));

        while (end < s.length() && start < end) {
            char nextChar = s.charAt(end);
            if (set.contains(nextChar)) {
                result = Math.max(result, set.size());
                for (int i = start; i <= end; i++) {
                    if (s.charAt(i) == nextChar) {
                        start = i + 1;
                        break;
                    }
                    set.remove(s.charAt(i));
                }
                end++;
                continue;
            }
            set.add(nextChar);
            end++;
        }
        result = Math.max(result, set.size());
        return result;
    }
}
