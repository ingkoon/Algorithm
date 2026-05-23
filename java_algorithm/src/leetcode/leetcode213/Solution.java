package leetcode.leetcode213;

class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 3) {
            int result = 0;
            for(int num : nums) {
                result = Math.max(result, num);
            }
            return result;
        }
        int case1 = rob(nums, 0, nums.length - 2);
        int case2 = rob(nums, 1, nums.length - 1);

        int result = Math.max(case1, case2);
        return result;
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = nums[start + 1];

        for(int i = start + 2; i <= end; i++) {
            int sum = 0;
            for(int j = 0; j < i-1; j++){
                sum = Math.max(sum, dp[j] + nums[i]);
            }
            dp[i] = sum;
        }

        int result = Math.max(dp[end], dp[end-1]);
        return result;
    }
}