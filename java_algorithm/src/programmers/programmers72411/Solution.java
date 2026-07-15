package programmers.programmers72411;

import java.util.*;

public class Solution {
    static List<String>[] arr;

    public String[] solution(String[] orders, int[] course) {
        arr = new ArrayList[course[course.length - 1] + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < course.length; i++) {
            for (String order : orders) {
                boolean[] visited = new boolean[order.length()];
                combination(order, "", 0, course[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int size : course) {
            Map<String, Integer> map = new HashMap<>();
            List<String> maxList = new ArrayList<>();
            List<String> list = arr[size];
            int cnt = 2;
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
            }

            Set<String> keys = map.keySet();
            for (String key : keys) {
                int curCnt = map.get(key);
                if (curCnt > cnt) {
                    maxList = new ArrayList<>();
                    maxList.add(key);
                    cnt = curCnt;
                } else if (curCnt == cnt) {
                    maxList.add(key);
                }
            }

            for (String s : maxList) {
                result.add(s);
            }
        }

        String[] answer = result.toArray(new String[0]);
        Arrays.sort(answer);

        return answer;
    }

    private void combination(String order, String current, int start, int targetSize) {
        if (current.length() == targetSize) {
            char[] chars = current.toCharArray();
            Arrays.sort(chars);
            arr[targetSize].add(new String(chars));
            return;
        }

        for (int i = start; i < order.length(); i++) {
            combination(order, current + order.charAt(i), i + 1, targetSize);
        }
    }
}