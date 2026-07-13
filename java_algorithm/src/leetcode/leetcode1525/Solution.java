package leetcode.leetcode1525;

public class Solution {
    final static int SIZE = 26;
    public int numSplits(String s) {
        int[] left = new int[SIZE];
        int[] right = new int[SIZE];

        int leftCnt = 0;
        int rightCnt = 0;

        int result = 0;

        for(int i = 0 ; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(right[idx] == 0) {
                rightCnt++;
            }
            right[idx]++;
        }

        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(left[idx] == 0) {
                leftCnt++;
            }
            left[idx]++;

            right[idx]--;
            if(right[idx] == 0) {
                rightCnt--;
            }

            if(leftCnt == rightCnt) {
                result++;
            }
        }

        return result;
    }
}
