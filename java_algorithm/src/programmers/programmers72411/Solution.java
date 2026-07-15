package programmers.programmers72411;

import java.util.*;

public class Solution {
    static List<String>[] arr;

    public String[] solution(String[] orders, int[] course) {

        /**
         * course 배열의 크기는 1 이상 10 이하입니다.
         * course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
         * course 배열에는 같은 값이 중복해서 들어있지 않습니다.
         */
        arr = new ArrayList[course[course.length - 1] + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < orders.length; i++) {
            for (int courseSize : course) {
                combination(orders[i], "", 0, courseSize);
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

            result.addAll(maxList);
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