package leetcode.leetcode56;
import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();
        int[] merging = intervals[0];

        for(int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] <= merging[1]){
                merging[1] = Math.max(merging[1], cur[1]);
                continue;
            }
            list.add(merging);
            merging = cur;
        }
        list.add(merging);
        int[][] result = list.toArray(new int[0][]);
        return result;
    }
}