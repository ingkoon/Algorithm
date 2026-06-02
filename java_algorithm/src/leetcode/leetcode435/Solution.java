package leetcode.leetcode435;
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;

        Arrays.sort(intervals, (interval1, interval2) -> {
            if(interval1[1] == interval2[1]) {
                return interval1[0] - interval2[0];
            }
            return interval1[1] - interval2[1];
        });

        int[] cur = new int[] {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] < cur[1]) {
                result++;
                cur[1] = Math.min(cur[1], interval[1]);
                continue;
            }
            cur[1] = interval[1];
        }

        return result;
    }
}
