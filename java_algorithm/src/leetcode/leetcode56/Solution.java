package leetcode.leetcode56;
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int[] tmp = intervals[0];
        int idx = 1;

        while(idx < intervals.length) {
            int[] cur = intervals[idx];
            if(cur[0] <= tmp[1]){
                tmp[1] = Math.max(tmp[1], cur[1]);
                idx++;
                continue;
            }
            list.add(tmp);
            tmp = cur;
            idx++;
        }

        list.add(tmp);
        int[][] result = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
