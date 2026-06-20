package leetcode.leetcode49;
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(s);
            map.put(sortedStr, list);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}