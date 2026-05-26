package leetcode.leetcode55;

public class Solution {
    public boolean canJump(int[] nums) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(idx < i) {
                return false;
            }

            idx = Math.max(idx, nums[i] + i);
            if(idx >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}