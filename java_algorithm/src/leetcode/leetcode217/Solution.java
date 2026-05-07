package leetcode.leetcode217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int cnt = map.getOrDefault(i, 0);
            map.put(i, ++cnt);
        }

        Set<Integer> keySet = map.keySet();
        for(int i : keySet) {
            if(map.getOrDefault(i, 0) > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateV2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
