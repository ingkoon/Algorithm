package leetcode.leetcode300;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = nums.length;
        Arrays.fill(dp, 1);
        for(int i = 1; i < size; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < size; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int lengthOfLISV2(int[] nums) {
        int[] dp = new int[nums.length];
        int size = nums.length;
        int idx = 0;
        dp[idx] = nums[idx];
        for(int i = 1; i < size; i++) {
            if(nums[i] > dp[idx]) {
                idx++;
                dp[idx] = nums[i];
                continue;
            }
            update(dp, nums[i], 0, idx);
        }

        return idx + 1;
    }

    private void update(int[] dp, int num, int left, int right) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(dp[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        dp[left] = num;
    }
}
