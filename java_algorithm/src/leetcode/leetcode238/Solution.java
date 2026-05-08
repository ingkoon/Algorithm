package leetcode.leetcode238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrSize = nums.length;
        int[] left = new int[arrSize];
        int[] right = new int[arrSize];

        left[0] = nums[0];
        right[arrSize - 1] = nums[arrSize - 1];

        for(int i = 1; i < arrSize; i++) {
            left[i] = left[i-1] * nums[i];
        }
        for(int i = arrSize - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] result = new int[arrSize];

        result[0] = right[1];
        result[arrSize - 1] = left[arrSize - 2];
        for(int i = 1; i < arrSize - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }
        return result;
    }
}
