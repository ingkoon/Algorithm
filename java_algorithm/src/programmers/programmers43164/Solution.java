package programmers.programmers43164;

import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> routeList;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routeList = new ArrayList<>();

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        routeList.add("ICN");
        dfs("ICN", routeList, tickets, 0);

        return routeList.toArray(new String[0]);
    }

    private boolean dfs(String current, List<String> route, String[][] tickets, int count) {
        // 모든 티켓을 전부 사용한 경우 (성공)
        if (count == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets[i][1], route, tickets, count + 1)) {
                    return true;
                }
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }

        return false;
    }
}