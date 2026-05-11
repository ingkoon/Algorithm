package leetcode.leetcode33;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {7, 0, 1, 2, 3, 4, 5};
        int target = 0;

        System.out.println(search(nums, target));
    }
    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target &&  target <= nums[mid]) {
                    right = mid;
                } else{
                    left = mid + 1;
                }
            }
            else if(nums[mid] <= nums[right]) {
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        if(nums[left] == target) {
            return left;
        }

        return -1;
    }
}