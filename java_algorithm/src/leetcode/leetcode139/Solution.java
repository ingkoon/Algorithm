package leetcode.leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);
                if(dp[j] && set.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
