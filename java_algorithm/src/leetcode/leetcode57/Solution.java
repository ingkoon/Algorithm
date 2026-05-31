package leetcode.leetcode57;
import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        List<int[]> list = new ArrayList<>();

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]){
            list.add(intervals[idx]);
            idx++;
        }

        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }

        list.add(new int[] {newStart, newEnd});
        while (idx < intervals.length) {
            list.add(intervals[idx]);
            idx++;
        }

        int size = list.size();
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
