package leetcode.leetcode121;

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int item = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < item) {
                item = prices[i];
                continue;
            }
            result = Math.max(result, prices[i] - item);
        }
        return result;
    }
}