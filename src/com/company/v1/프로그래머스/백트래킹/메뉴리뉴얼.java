package com.company.v1.프로그래머스.백트래킹;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 메뉴리뉴얼 {

    private static Map<String, Integer> foods;
    private static int max;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) {
            foods = new HashMap<>();
            max = 0;

            for (int j = 0; j < orders.length; j++) {
                makeComb(0, course[i], "", 0, orders[j]);
            }

            for (String food : foods.keySet()) {
                int recommendCnt = foods.get(food);

                if (recommendCnt == max && max > 1) {
                    pq.add(food);
                }
            }
        }

        String[] result = new String[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        return result;
    }

    private static void makeComb(int depth, int targetLen, String candidate, int index, String order) {
        if (depth == targetLen) {
            char[] chars = candidate.toCharArray();
            Arrays.sort(chars);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
            }

            candidate = sb.toString();
            foods.put(candidate, foods.getOrDefault(candidate, 0) + 1);
            max = Math.max(max, foods.get(candidate));

            return;
        }

        for (int i = index; i < order.length(); i++) {
            char c = order.charAt(i);
            makeComb(depth + 1, targetLen, candidate + c, i + 1, order);
        }
    }

}
