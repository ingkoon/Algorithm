package leetcode.leetcode128;

import java.util.HashSet;
import java.util.Set;


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int result = 0;
        for(int num : set) {
            if(set.contains(num - 1)) {
                continue;
            }
            int tmp = 0;
            while(set.contains(num)) {
                tmp++;
                num++;
            }
            result = Math.max(result, tmp);
        }
        return result;
    }
}
