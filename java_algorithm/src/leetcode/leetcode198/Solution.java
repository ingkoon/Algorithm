package leetcode.leetcode198;

class Solution {
    public int robV1(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i = 2; i < nums.length; i++) {
            int sum = 0;
            for(int j = 0; j < i-1; j++) {
                if(sum < dp[j] + nums[i])
                    sum = dp[j] + nums[i];
            }
            dp[i] = sum;
        }

        int result = Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        return result;

    }

    public int robV2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2] + nums[i]);
        }

        int result = Math.max(dp[nums.length - 1], dp[nums.length - 2]);
        return result;
    }
}