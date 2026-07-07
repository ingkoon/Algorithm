package leetcode.leetcode122;

public class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int result = 0;
        for (int i = 1; i < size; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }
}