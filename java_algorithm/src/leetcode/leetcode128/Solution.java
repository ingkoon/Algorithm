package leetcode.leetcode128;

import java.util.HashSet;
import java.util.Set;


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currentStreak = 0;
            int cur = num;
            while(set.contains(cur)) {
                currentStreak++;
                cur++;
            }
            result = Math.max(result, currentStreak);
        }
        return result;
    }
}
