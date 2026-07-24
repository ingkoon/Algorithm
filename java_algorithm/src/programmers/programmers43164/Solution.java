package programmers.programmers43164;

import java.util.*;

public class Solution {
    static boolean[] visited;
    static List<String> allRoutes = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        dfs("ICN", "ICN", tickets, 0);

        return allRoutes.get(0).split(" ");
    }

    public void dfs(String current, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            allRoutes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}
