package leetcode.leetcode152;

public class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(cur < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(cur, max * cur);
            min = Math.min(cur, min * cur);
            result = Math.max(result, max);
        }

        return result;
    }
}
