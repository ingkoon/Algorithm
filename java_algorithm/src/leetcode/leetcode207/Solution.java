package leetcode.leetcode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] prerequisit : prerequisites) {
            int des = prerequisit[0];
            int dep = prerequisit[1];
            adj[des].add(dep);
            indegree[dep]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visitCount = 0;
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            visitCount++;

            for(int i : adj[idx]) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return visitCount == numCourses;
    }
}
