package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _767 {
    public String reorganizeString(String s) {
        Map<Character, Integer> chToCntMap = new HashMap<>();
        Queue<Character> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(chToCntMap.get(o2), chToCntMap.get(o1)));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            chToCntMap.put(s.charAt(i), chToCntMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        pq.addAll(chToCntMap.keySet());

        while (!pq.isEmpty()) {
            char c1 = pq.poll();
            if (pq.isEmpty()) {
                if(chToCntMap.get(c1) > 1) return "";
                else sb.append(c1);
                break;
            }

            char c2 = pq.poll();
            sb.append(c1).append(c2);
            chToCntMap.put(c1, chToCntMap.get(c1) - 1);
            chToCntMap.put(c2, chToCntMap.get(c2) - 1);

            if(chToCntMap.get(c1) != 0) pq.add(c1);
            if(chToCntMap.get(c2) != 0) pq.add(c2);
        }

        return sb.toString();
    }
}
