package leetcode.leetcode53;

class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int num = nums[0];

        for(int i = 1; i < nums.length; i++) {
            num = Math.max(num + nums[i], nums[i]);
            result = Math.max(result, num);
        }

        return result;
    }
}
